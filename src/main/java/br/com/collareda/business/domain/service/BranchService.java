package br.com.collareda.business.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.collareda.business.domain.exception.NegocioException;
import br.com.collareda.business.domain.model.BranchEntity;
import br.com.collareda.business.domain.repository.BranchRepository;

@Service
public class BranchService {

	@Autowired
	private BranchRepository branchRepository;

	public BranchEntity register(BranchEntity branch) {

		List<BranchEntity> branchExisting = branchRepository.findByDescription(branch.getDescription());

		if (branchExisting != null && !branchExisting.isEmpty()) {
			throw new NegocioException("Ramo já cadastrado no sistema.");
		}

		if (branch.getDescription() == null || branch.getDescription().isEmpty()) {
			throw new NegocioException("Descrição do ramo não pode ser vazia.");
		}

		return branchRepository.save(branch);
	}
	
	
	public List<BranchEntity> listAll() {
		return branchRepository.findAll();
	}

}
