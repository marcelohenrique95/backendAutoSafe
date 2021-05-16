package br.com.collareda.business.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.collareda.business.domain.model.BrandEntity;
import br.com.collareda.business.domain.service.BrandService;

@RestController
@RequestMapping("/brand")
public class BrandController {

	@Autowired
	private BrandService brandService;

	
	@GetMapping(path = "/listAllBrand/{typeVehicle}")
	public List<BrandEntity> listll(@PathVariable int typeVehicle){
		return brandService.findByTypeVehicle(typeVehicle);
	}

}
