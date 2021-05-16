package br.com.collareda.business.domain.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.sun.istack.NotNull;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ServiceEntity extends DefaultEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	@Column(name = "id_service")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "id_partner")
	private PartnerEntity partner;

	@NotNull
	@Column
	private String title;

	@NotNull
	@Column
	private String description;

	@Column
	private String imgUrl;
	
	@Column
	private BigDecimal value;

	@Column
	private int estimatedMinutes;

	@Column
	private LocalDate lastDateOfService;

	@OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	@JoinColumn(name = "id_service_branch")
	private List<ServiceBranchEntity> branchs;

	@Column
	private String tags;

	@OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	@JoinColumn(name = "id_service_vehicle")
	private List<ServiceVehicleEntity> serviceVehicles;

}
