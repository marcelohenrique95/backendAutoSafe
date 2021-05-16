package br.com.collareda.business.api.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.com.collareda.business.domain.dto.ListVehiclesServiceDTO;
import br.com.collareda.business.domain.model.ServiceEntity;
import br.com.collareda.business.domain.model.ServiceVehicleEntity;
import br.com.collareda.business.domain.service.ServiceService;
import br.com.collareda.business.domain.service.ServiceVehicleService;
@RestController
@RequestMapping("/service")
public class ServiceController {
	@Autowired
	private ServiceService serviceService;
	
	@Autowired
	private ServiceVehicleService serviceVehicleService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ServiceEntity createService(@RequestBody ServiceEntity service, @RequestHeader (name="Authorization") String token) {
		return serviceService.createService(service, token);
	}
	
	@PostMapping(path = "/uploadFile/{serviceId}")
	@ResponseStatus(HttpStatus.CREATED)
	public BodyBuilder upload(@RequestParam("file") MultipartFile file, @PathVariable Long serviceId) throws IOException {
		System.out.println("Original Image Byte Size - " + file.getBytes().length);
		serviceService.addImg(file, serviceId);
		return ResponseEntity.status(HttpStatus.OK);
	}

	@PostMapping(path = "/addVehicle")
	@ResponseStatus(HttpStatus.CREATED)
	public void addVehicle(@RequestBody ServiceVehicleEntity vehicle) {
		serviceVehicleService.addVehicle(vehicle);
	}
	
	@GetMapping(path = "/listVehicle/{serviceId}")
	public List<ListVehiclesServiceDTO> listVehicles(@PathVariable Long serviceId) {
		return serviceVehicleService.listVehiclesByServiceId(serviceId);
	}
	
	@DeleteMapping(path = "/removeVehicle/{vehicleId}")
	public void deleteVehicles(@PathVariable Long vehicleId) {
		 serviceVehicleService.deleteVehicle(vehicleId);
	}
}
