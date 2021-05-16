package br.com.collareda.business.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.collareda.business.domain.dto.UserFilterDTO;
import br.com.collareda.business.domain.model.UserEntity;
import br.com.collareda.business.domain.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping
	public UserEntity login(@RequestHeader String email, @RequestHeader String password) {
		return userService.login(email, password);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public UserEntity register(@RequestBody UserEntity user) {
		return userService.register(user);
	}

	@PutMapping
	public UserEntity alter(@RequestBody UserEntity user) {
		return userService.alter(user);
	}

	@GetMapping(path = "/listAll")
	public List<UserEntity> list(@RequestHeader(name = "Authorization") String token) {
		return userService.listAll();
	}
	
	@PostMapping(path = "/listByFilter")
	public List<UserEntity> listByFilter(@RequestBody UserFilterDTO userFilterDTO){
		return userService.listByFilter(userFilterDTO);
	}

}
