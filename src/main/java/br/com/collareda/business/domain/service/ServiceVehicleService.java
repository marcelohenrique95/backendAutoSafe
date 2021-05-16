package br.com.collareda.business.domain.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.collareda.business.domain.dto.ListVehiclesServiceDTO;
import br.com.collareda.business.domain.model.ServiceVehicleEntity;
import br.com.collareda.business.domain.repository.ServiceVehicleRepository;

@Service
public class ServiceVehicleService {
	private static final Logger log = LoggerFactory.getLogger(ServiceVehicleService.class);

	@Autowired
	private ServiceVehicleRepository serviceVehicleRepository;
	
	public void addVehicle(ServiceVehicleEntity vehicle){
		log.info("Add Vehicle to service:" + vehicle.getIdService());
		serviceVehicleRepository.save(vehicle);
	}

	public List<ListVehiclesServiceDTO> listVehiclesByServiceId(Long serviceId) {
		return serviceVehicleRepository.listVehiclesByServiceId(serviceId);
	}
	
	public void deleteVehicle(Long vehicleId) {
		serviceVehicleRepository.deleteById(vehicleId);
	}

}
