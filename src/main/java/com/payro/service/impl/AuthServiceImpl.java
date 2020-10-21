package com.payro.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.payro.dto.LoginRequest;
import com.payro.dto.RegisterRequest;
import com.payro.model.User;
import com.payro.repository.UserRepository;
import com.payro.security.JwtProvider;
import com.payro.service.AuthService;

@Service
public class AuthServiceImpl implements AuthService {

	@Autowired
	private UserRepository userRepository; 
	@Autowired
	private PasswordEncoder passwordEncoder; 
	@Autowired
	private AuthenticationManager authenticationManager;  
	@Autowired
	private JwtProvider jwtProvider;

	@Override
	public void signup(RegisterRequest registerRequest) {
		User user = new User();
		user.setUsername(registerRequest.getUsername());
		user.setEmail(registerRequest.getEmail());
		user.setPassword(encondePassword(registerRequest.getPassword()));
		userRepository.save(user);

	}

	private String encondePassword(String password) {
		return passwordEncoder.encode(password);
	}

	public String login(LoginRequest loginRequest) {
		Authentication authenticate = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
		SecurityContextHolder
		.getContext()
		.setAuthentication(authenticate);
		return jwtProvider.generateToken(authenticate);
	}
	
	@Override
	public Optional<org.springframework.security.core.userdetails.User> getCurrentUser() {
		org.springframework.security.core.userdetails.User principal = (org.springframework.security.core.userdetails.User) SecurityContextHolder
				.getContext().getAuthentication().getPrincipal();
		return Optional.of(principal);
	}
	
}
