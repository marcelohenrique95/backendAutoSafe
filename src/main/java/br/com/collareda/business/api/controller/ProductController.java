package br.com.collareda.business.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.collareda.business.domain.model.ProductEntity;
import br.com.collareda.business.domain.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ProductEntity registerProduct(@RequestBody ProductEntity product) {
		return productService.register(product);
	}
	
	@GetMapping(path = "/listAllProduct ")
	public List<ProductEntity> listAllProduct(){
		return productService.listAllProduct();
	}

}
