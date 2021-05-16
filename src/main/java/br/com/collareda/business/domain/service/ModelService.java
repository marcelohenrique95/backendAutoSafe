package br.com.collareda.business.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.collareda.business.domain.model.ModelEntity;
import br.com.collareda.business.domain.repository.ModelRepository;

@Service
public class ModelService {
	
	@Autowired
	private ModelRepository modelRepository;

	public List<ModelEntity> listAll(){
		return modelRepository.findAll();
	}
	
	public List<ModelEntity> listAllModel(Long id){
		return modelRepository.findByBrand(id);
	}
}	
