package br.com.collareda.business.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddVehicleRequestDTO {
	private Long idService;
	private Long idModel;
	private Long idBrand;
	private Long idFuel;
}
