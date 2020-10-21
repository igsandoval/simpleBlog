package com.payro.service;

import java.util.Optional;

import com.payro.dto.LoginRequest;
import com.payro.dto.RegisterRequest;

public interface AuthService {
 
	public void signup(RegisterRequest registerRequest) ;
	public String  login(LoginRequest loginRequest);
	public Optional<org.springframework.security.core.userdetails.User> getCurrentUser();
}
