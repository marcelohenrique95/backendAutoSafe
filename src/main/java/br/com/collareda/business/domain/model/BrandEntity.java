package br.com.collareda.business.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class BrandEntity {

	@JsonProperty(value = "Value")
	@Id
	@Column(name = "id_brand")
	private Long id;

	@JsonProperty(value = "Label")
	@Column
	private String name;

	@Column
	private int typeVehicle;

}
