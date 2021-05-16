package br.com.collareda.business.domain.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import com.sun.istack.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public class DefaultEntity {
	@NotNull
	@Column
	private boolean disable;
	
	@NotNull
	@Column
	private Long idUserCreate;
	
	@NotNull
	@Column
	private LocalDateTime createDate;
}
