package com.example.springrest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class LoginController {
	
	@Autowired
	private AuthenticationManager manager;
	
	@PostMapping("/login")
	public ResponseEntity<JwtResponse> login(@RequestBody JwtRequest request)
	{
		
	}
	
	private void doAuthenticate(String email, String password)
	{
		UsernamePasswordAuthenticationToken authenticate = new UsernamePasswordAuthenticationToken(email, password);
		try {
			manager.authenticate(authenticate);
		}
		
	}
}
