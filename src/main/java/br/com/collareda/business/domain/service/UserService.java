package br.com.collareda.business.domain.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.collareda.business.domain.dto.UserFilterDTO;
import br.com.collareda.business.domain.exception.NegocioException;
import br.com.collareda.business.domain.model.UserEntity;
import br.com.collareda.business.domain.repository.UserRepository;
import br.com.collareda.business.domain.repository.dao.UserDAO;
import br.com.collareda.business.jwt.JwtTokenUtil;

@Service
public class UserService {
	
	@Autowired
	private JwtTokenUtil jwt;

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserDAO userDAO;

	public UserEntity register(UserEntity user) {

		UserEntity userExisting = userRepository.findByEmail(user.getEmail());

		if (userExisting != null && userExisting.getEmail().equals(user.getEmail())) {
			throw new NegocioException("Já existe um usuario cadastrado com esse email.");
		}

		if (user.getName() == null || user.getName().isEmpty()) {
			throw new NegocioException("Nome não pode ser vazio !");
		}

		if (user.getPassword() == null || user.getPassword().isEmpty() || user.getPassword().length() < 6) {
			throw new NegocioException("Senha tem que conter mais de 6 digitos !");
		}
		
		if(user.getEmail() == null || user.getEmail().isEmpty()) {
			throw new NegocioException("Preencha o email.");
		}
		
		user.setDateRegister(LocalDateTime.now());
		user.setActive(true);

		return userRepository.save(user);

	}

	public UserEntity login(String email, String password) {

		if (email == null || email.isEmpty() || password == null || password.isEmpty()) {
			throw new NegocioException("Digite email e senha !");
		}
		UserEntity userExisting = userRepository.findByEmail(email);

		if (userExisting == null || !password.equals(userExisting.getPassword())) {
			throw new NegocioException("Senha inválida !");
		}
		return userExisting;
	}

	public UserEntity alter(UserEntity newUser) {
	
		Optional<UserEntity> userExisting = userRepository.findById(newUser.getId());

		if (!userExisting.isPresent()) {
			throw new NegocioException("Usuario não existe.");
		}

		List<UserEntity> usersByEmail = userRepository.listByEmail(newUser.getEmail());

		for (UserEntity userItem : usersByEmail) {
			if (!newUser.equals(userItem)) {
				throw new NegocioException("Esse email já está cadastrado em outra conta.");

			}

		}

		userExisting.get().setName(newUser.getName());
		userExisting.get().setEmail(newUser.getEmail());
		userExisting.get().setPassword(newUser.getPassword());
		userExisting.get().setActive(newUser.getActive());

		return userRepository.save(userExisting.get());
	}
	
	public List<UserEntity> listAll() {
		return userRepository.findAll();
	}
	
	public List<UserEntity> listByFilter(UserFilterDTO userFilterDTO){
		return userDAO.findUserByFilter(userFilterDTO);
	}
	
	public Optional<UserEntity> findByEmail(String email){
		return Optional.ofNullable(userRepository.findByEmail(email));
	}
}
