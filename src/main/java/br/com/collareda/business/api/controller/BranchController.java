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

import br.com.collareda.business.domain.model.BranchEntity;
import br.com.collareda.business.domain.service.BranchService;

@RestController
@RequestMapping("/branch")
public class BranchController {
	
	@Autowired
	private BranchService branchService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public BranchEntity registerBranch(@RequestBody BranchEntity branch) {
		return branchService.register(branch);
	}
	
	@GetMapping(path = "/listAllBranch")
	public List<BranchEntity> list(@RequestHeader(name = "Authorization") String token) {
		return branchService.listAll();
	}

}
