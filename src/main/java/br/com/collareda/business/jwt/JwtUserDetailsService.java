package br.com.collareda.business.jwt;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.collareda.business.domain.model.UserEntity;
import br.com.collareda.business.domain.service.UserService;

@Service
public class JwtUserDetailsService implements UserDetailsService{

	@Autowired
	private UserService userService;

	public JwtUser loadJwtUserByUsername(String email) throws UsernameNotFoundException {
		Optional<UserEntity> user = userService.findByEmail(email);

		if (user.isPresent()) {
			JwtUser jwtUser = new JwtUser();
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			jwtUser.setPassword(passwordEncoder.encode(user.get().getPassword()));
			jwtUser.setUserId(user.get().getId());
			jwtUser.setUsername(user.get().getEmail());
			jwtUser.setPartnerId(user.get().getIdPartner());
			return jwtUser;
		} else {
			throw new UsernameNotFoundException("User not found with email: " + email);
		}
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<UserEntity> user = userService.findByEmail(username);

		if (user.isPresent()) {
			 BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			 String encodedPassword = passwordEncoder.encode(user.get().getPassword());
			return new User(user.get().getEmail(), encodedPassword, new ArrayList<>());
		} else {
			throw new UsernameNotFoundException("User not found with email: " + username);
		}
	}
}