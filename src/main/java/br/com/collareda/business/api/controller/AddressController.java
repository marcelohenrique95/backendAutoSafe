package br.com.collareda.business.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.collareda.business.domain.dto.CepResponseDTO;
import br.com.collareda.business.domain.service.CepService;

@RestController
@RequestMapping("/address")
public class AddressController {
	
	@Autowired
	private CepService cepService;

	@GetMapping(path = "/getCep/{cep}")
	public CepResponseDTO cep(@PathVariable("cep") String cep) {
		CepResponseDTO cepResponse = null;
		try {
			cepResponse = cepService.buscaEnderecoPelo(cep);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cepResponse;
	}
}
