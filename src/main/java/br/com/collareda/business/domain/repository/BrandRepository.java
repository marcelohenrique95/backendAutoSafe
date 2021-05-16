package br.com.collareda.business.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.collareda.business.domain.model.BrandEntity;

@Repository
public interface BrandRepository extends JpaRepository<BrandEntity, Long> {
	
	List<BrandEntity> findByTypeVehicleOrderByNameAsc(int typeVehicle);

}
