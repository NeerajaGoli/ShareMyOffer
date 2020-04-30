package com.neeraja.ShareMyOffer.controllers;


import com.neeraja.ShareMyOffer.dto.LoginDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")

public class AuthController {
	
	private static Logger logger = LoggerFactory.getLogger(AuthController.class);
	
	@GetMapping("/showMyLoginPage")
	public String showMyLoginPage() {
		logger.info("In auth controller");
		return "login-page";
	}
	



	
	@GetMapping("/login")
	public String loginPage() {
		return "login-page";
	}
	
	
	@GetMapping("/home")
	public String homePage() {
		return "home-page";
	}


	
	
		
	@GetMapping("/signup")
	public String signupPage() {
		
		return "signup-page";
	}
	
	@GetMapping("/otp")
	public String verifyPage() {
		
		return "otp-page";
	}

}
