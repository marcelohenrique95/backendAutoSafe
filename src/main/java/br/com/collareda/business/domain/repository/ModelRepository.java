package br.com.collareda.business.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.collareda.business.domain.model.ModelEntity;

@Repository
public interface ModelRepository extends JpaRepository<ModelEntity, Long> {
	
	@Query("SELECT modelEntity FROM ModelEntity modelEntity WHERE modelEntity.brand.id = :idBrand ORDER BY name")
	List<ModelEntity> findByBrand(@Param("idBrand")  Long id);

}
