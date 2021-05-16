package br.com.collareda.business.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.collareda.business.domain.model.ModelEntity;
import br.com.collareda.business.domain.service.ModelService;

@RestController
@RequestMapping("/model")
public class ModelController {

	@Autowired
	private ModelService modelService;
	
	@GetMapping(path = "/listAllModel/{idBrand}")
	public List<ModelEntity> listAll(@PathVariable Long idBrand ) {
		return modelService.listAllModel(idBrand);
	}

}
