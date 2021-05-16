package br.com.collareda.business.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserFilterDTO {
	
	@JsonProperty
	private String name;
	
	@JsonProperty
	private Boolean active;

}
