package br.com.collareda.business.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.collareda.business.domain.enums.TypePersonEnum;
import br.com.collareda.business.domain.exception.NegocioException;
import br.com.collareda.business.domain.model.PartnerEntity;
import br.com.collareda.business.domain.repository.AddressRepository;
import br.com.collareda.business.domain.repository.PartnerRepository;
import br.com.collareda.business.domain.util.ValidDocument;

@Service
public class PartnerService {
	
	@Autowired
	private PartnerRepository partnerRepository;
	
	@Autowired
	private AddressRepository addressRepository;
	
	public PartnerEntity register(PartnerEntity partner) {

		PartnerEntity clientExisting = partnerRepository.findByEmail(partner.getEmail());

		if (clientExisting != null && clientExisting.getEmail().equals(partner.getEmail())) {
			throw new NegocioException("Já existe um usuario cadastrado com esse email.");
		}

		if (partner.getPrincipalName() == null || partner.getPrincipalName().isEmpty()) {
			throw new NegocioException("Nome não pode ser vazio !");
		}
		
		if (partner.getSecundaryName() == null || partner.getSecundaryName().isEmpty()) {
			throw new NegocioException("Sobrenome não pode ser vazio !");
		}
		
		if (partner.getBirthDate() == null) {
			throw new NegocioException("Digite uma data verdadeira !");
		}

		if (partner.getDocumentNumber() == null || partner.getDocumentNumber().isEmpty())  {
			throw new NegocioException("CPF ou CNPJ tem que conter mais de 11 digitos !");
		}
		
		if (partner.getCellphoneNumber() == null || partner.getCellphoneNumber().isEmpty()) {
			throw new NegocioException("Digite um numero de celular!");
		}
		
		if (partner.getTelephoneNumber() == null || partner.getTelephoneNumber().isEmpty()) {
			throw new NegocioException("Preencha o telefone !");
		}
						
		if(partner.getEmail() == null || partner.getEmail().isEmpty()) {
			throw new NegocioException("Preencha o email.");
		}
		
		if(TypePersonEnum.PF.equals(partner.getTypePerson()) && !ValidDocument.isValidCPF(partner.getDocumentNumber().replaceAll("[^0-9]", ""))) {
			throw new NegocioException("CPF inválido!");
		}
		
		if(TypePersonEnum.PJ.equals(partner.getTypePerson()) && !ValidDocument.isValidCNPJ(partner.getDocumentNumber().replaceAll("[^0-9]", ""))) {
			throw new NegocioException("CNPJ inválido");
		}
		 
		if (partner.getAddress().getCity() == null && partner.getAddress().getCity().isEmpty()) {
			throw new NegocioException("Preencha todos os campos.");
		}
		
		if (partner.getAddress().getNeighborhood() == null && partner.getAddress().getNeighborhood().isEmpty()) {
			throw new NegocioException("Preencha todos os campos.");
		}
		
		if (partner.getAddress().getComplement() == null && partner.getAddress().getComplement().isEmpty()) {
			throw new NegocioException("Preencha todos os campos.");
		}
		
		if (partner.getAddress().getNumber() == null && partner.getAddress().getNumber().isEmpty()) {
			throw new NegocioException("Preencha todos os campos.");
		}
		
		if (partner.getAddress().getState() == null && partner.getAddress().getState().isEmpty()) {
			throw new NegocioException("Preencha todos os campos.");
		}
		
		if (partner.getAddress().getZipCode() == null && partner.getAddress().getZipCode().isEmpty()) {
			throw new NegocioException("Preencha todos os campos.");
		}
		//partner.set
		return partnerRepository.save(partner);
		

	}
	
	public List<PartnerEntity> listAllPartner(){
		return partnerRepository.findAll();
	}


}
