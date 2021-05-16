package br.com.collareda.business.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.collareda.business.domain.model.BrandEntity;
import br.com.collareda.business.domain.repository.BrandRepository;

@Service
public class BrandService {

	@Autowired
	private BrandRepository brandRepository;

	public List<BrandEntity> listAll() {
		return brandRepository.findAll();

	}
	
	public List<BrandEntity> findByTypeVehicle(int typeVehicle){
		return brandRepository.findByTypeVehicleOrderByNameAsc(typeVehicle);
	}

}
