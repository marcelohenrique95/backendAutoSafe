package br.com.collareda.business.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.collareda.business.domain.model.AddressEntity;

@Repository
public interface AddressRepository extends JpaRepository<AddressEntity, Long>{
	
	List<AddressEntity> findByCity(String city);
	List<AddressEntity> findByCityContaining(String city);

}
