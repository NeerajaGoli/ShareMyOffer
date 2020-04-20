package com.neeraja.ShareMyOffer.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.neeraja.ShareMyOffer.entities.Login;

@Controller
@RequestMapping("/shareMyOffer")
public class AuthController {

	@GetMapping("/login")
	private String loginPage(Model theModel) {
		Login user = new Login();
		theModel.addAttribute("user",user);
		return "login-page";
	}

}
