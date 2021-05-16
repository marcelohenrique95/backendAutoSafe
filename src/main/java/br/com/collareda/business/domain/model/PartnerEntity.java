package br.com.collareda.business.domain.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.sun.istack.NotNull;

import br.com.collareda.business.domain.enums.TypePersonEnum;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class PartnerEntity extends DefaultEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	@Column(name = "id_partner")
	private Long id;

	@NotNull
	@Column
	private String principalName;

	@NotNull
	@Column
	private String secundaryName;

	@NotNull
	@Column
	private Date birthDate;

	@NotNull
	@Column
	private String documentNumber;

	@NotNull
	@Column
	private String cellphoneNumber;

	@NotNull
	@Column
	private String telephoneNumber;

	@NotNull
	@Column
	private String email;

	@NotNull
	@Column
	private TypePersonEnum typePerson;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id", referencedColumnName = "id")
	private AddressEntity address;

}
