package br.com.collareda.business.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.collareda.business.domain.model.PartnerEntity;
import br.com.collareda.business.domain.service.PartnerService;
import br.com.collareda.business.jwt.JwtTokenUtil;

@RestController
@RequestMapping("/partner")
public class PartnerController {

	@Autowired
	private JwtTokenUtil jwt;

	@Autowired
	private PartnerService partnerService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public PartnerEntity registerPartner(@RequestBody PartnerEntity partner) {
		return partnerService.register(partner);
	}

	@GetMapping(path = "/listAllPartner")
	public List<PartnerEntity> listPartner(@RequestHeader(name = "Authorization") String token) {
		System.out.println("TOKEN:" + token);
		System.out.println("PARTNER ID:" + jwt.getPartnerID(token.replace("Bearer ", "")));
		return partnerService.listAllPartner();
	}

}
