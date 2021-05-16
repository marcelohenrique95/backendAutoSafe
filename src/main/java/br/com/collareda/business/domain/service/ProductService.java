package br.com.collareda.business.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.collareda.business.domain.exception.NegocioException;
import br.com.collareda.business.domain.model.ProductEntity;
import br.com.collareda.business.domain.repository.ProductRepository;
import br.com.collareda.business.jwt.JwtTokenUtil;

@Service
public class ProductService {
	
	@Autowired
	private JwtTokenUtil jwt;
	
	@Autowired
	private ProductRepository productRepository;
	
	public ProductEntity register(ProductEntity product) {
		
		ProductEntity productExisting =  productRepository.findByProducer(product.getProducer());
		
		if(productExisting != null && productExisting.getName().equals(product.getName())) {
			throw new NegocioException("Esse produto já está cadastrado no sistema.");
		}
		
		if(product.getName() == null || product.getName().isEmpty()) {
			throw new NegocioException("Digite um nome.");
		}
		
		if(product.getProducer() == null || product.getProducer().isEmpty()) {
			throw new NegocioException("Digite o nome da fabricante.");
		}
		
		if(product.getPrice() == null || product.getPrice().isEmpty()) {
			throw new NegocioException("Digite o preço.");
		}
		
		if(product.getStock() == null || product.getStock().isEmpty()) {
			throw new NegocioException("Digite a quantidade no estoque.");
		}
		
		if(product.getType() == null || product.getType().isEmpty()) {
			throw new NegocioException("Digite o tipo");
		}
		
		return productRepository.save(product);
	}
	
	public void delete(ProductEntity product) {
		ProductEntity productExisting = (ProductEntity) productRepository.findByName(product.getName());
		productRepository.deleteById(product.getId());
	}
	
	public List<ProductEntity> listAllProduct() {
		return productRepository.findAll();
	}

}
