package br.com.collareda.business.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.sun.istack.NotNull;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ProductEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	@Column(name = "id_product")
	private Long id;
	
	@NotNull
	@Column
	private String name;
	
	@NotNull
	@Column
	private String producer;
	
	@NotNull
	@Column
	private String type;
	
	@NotNull
	@Column
	private String stock;
	
	@NotNull
	@Column
	private String price;
	
	

}
