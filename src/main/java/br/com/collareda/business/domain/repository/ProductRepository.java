package br.com.collareda.business.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.collareda.business.domain.model.ProductEntity;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long>{
	
	List<ProductEntity> findByName(String name);
	List<ProductEntity> findByNameContaining(String name);
	ProductEntity findByProducer(String producer);
	

}
