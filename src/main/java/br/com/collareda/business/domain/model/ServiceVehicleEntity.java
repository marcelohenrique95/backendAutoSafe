package br.com.collareda.business.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.collareda.business.domain.enums.FuelEnum;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ServiceVehicleEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	@Column(name = "id_service_vehicle")
	private Long id;
	
	@Column(name = "id_service", nullable = false)
	private Long idService;
	
	@Column(name = "id_brand", nullable = false)
	private Long idBrand;
	
	@Column(name = "id_model", nullable = false)
	private Long idModel;
	
	@Column
	private FuelEnum fuel;
}
