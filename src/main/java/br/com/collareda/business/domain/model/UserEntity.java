package br.com.collareda.business.domain.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.sun.istack.NotNull;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;

	@NotNull
	@Column
	private String name;
	
	@NotNull
	@Column
	private String email;
	
	@NotNull
	@Column
	@JsonProperty(access = Access.WRITE_ONLY)
	private String password;
	
	@NotNull
	@Column
	private LocalDateTime dateRegister;
	
	@NotNull
	@Column
	private Boolean active;
	
	@NotNull
	@Column
	private Long idPartner;

}
