package com.anudip.training.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.anudip.training.entity.Login;
import com.anudip.training.service.LoginService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.servlet.ServletException;

@RestController
@CrossOrigin("*")
public class LoginController {

	@Autowired
	LoginService loginService ;
	
	// http://localhost:8080/login
	@PostMapping("/login")
	public String validate(@RequestBody Login user) throws ServletException
	{
		String jwtToken="";
		
		if(user.getUserName() == null || user.getPassword() == null)
		{
			throw new ServletException("Plese fill username and password");
		}
		
		String userName = user.getUserName();
		String password = user.getPassword();
		
		user = loginService.loginUser(userName, password);
		
		jwtToken=	Jwts.builder().setSubject(userName).claim("roles","user").setIssuedAt(new Date())
		.signWith(SignatureAlgorithm.HS256,"secretkey").compact();
		return jwtToken;
		
	}
}
