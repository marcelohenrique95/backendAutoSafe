package br.com.collareda.business.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
public class ModelEntity {

	@JsonProperty(value = "Value")
	@Id
	@Column(name = "id_model")
	private Long id;

	@JsonProperty(value = "Label")
	@Column
	private String name;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_brand")
	@JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
	@JsonIgnore
	private BrandEntity brand;

}
