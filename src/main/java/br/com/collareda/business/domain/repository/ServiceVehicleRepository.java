package br.com.collareda.business.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.collareda.business.domain.dto.ListVehiclesServiceDTO;
import br.com.collareda.business.domain.model.ServiceVehicleEntity;

@Repository
public interface ServiceVehicleRepository extends JpaRepository<ServiceVehicleEntity, Long> {

	public List<ServiceVehicleEntity> findByIdService(Long idService);

	@Query(value = "select sve.id_service_vehicle as idServiceVehicle, "
			+ " CASE WHEN sve.id_brand = 0 THEN 'Todas' ELSE be.name END as brandName, "
			+ " CASE WHEN sve.id_model = 0 THEN 'Todos' ELSE me.name END as modelName , " + "sve.fuel as fuel "
			+ " from service_vehicle_entity sve " + " left join brand_entity be on be.id_brand  = sve.id_brand "
			+ " left join model_entity me on me.id_model  = sve.id_model "
			+ " where sve.id_service = :serviceId", nativeQuery = true)
	public List<ListVehiclesServiceDTO> listVehiclesByServiceId(@Param("serviceId") Long serviceId);
}
