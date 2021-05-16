package br.com.collareda.business.domain.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class CepResponseDTO {
	
	private String cep;
	
	private String logradouro;
	
	private String complemento;
	
	private String bairro;
	
	private String localidade;
	
	private String uf;
	
	private String unidade;
	
	private String ibge;
	
	private String gia;
	
	private String ddd;
	
	private String siafi;
	

}
