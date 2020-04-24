package com.neeraja.ShareMyOffer.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/shareMyOffer")
public class AuthController {

	
	
		
	@GetMapping("/signup")
	public String signupPage() {
		
		return "signup-page";
	}
	
	@GetMapping("/otp")
	public String verifyPage() {
		
		return "otp-page";
	}

}