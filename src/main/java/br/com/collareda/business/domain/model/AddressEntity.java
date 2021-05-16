package br.com.collareda.business.domain.model;

import java.io.Serializable;

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
public class AddressEntity implements Serializable {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;

	@NotNull
	@Column
	private String city;

	@NotNull
	@Column
	private String state;

	@NotNull
	@Column
	private String number;

	@NotNull
	@Column
	private String complement;

	@NotNull
	@Column
	private String neighborhood;

	@NotNull
	@Column
	private String zipCode;
}
