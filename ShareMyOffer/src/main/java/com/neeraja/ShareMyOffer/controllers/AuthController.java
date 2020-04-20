package com.neeraja.ShareMyOffer.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.neeraja.ShareMyOffer.dto.LoginDTO;

@Controller
@RequestMapping("/shareMyOffer")
public class AuthController {

	LoginDTO tempLogin = new LoginDTO();
	
	@GetMapping("/login")
	public String loginPage() {
		return "login-page";
	}
	
	@PostMapping("/validate")
	public String validate(@ModelAttribute("login")LoginDTO login,Model model) {
		tempLogin.setUsername("srivathsa");
		tempLogin.setPassword("srivathsa@123");
		if(tempLogin.getUsername().equals(login.getUsername()) && tempLogin.getPassword().equals(login.getPassword())) {
			model.addAttribute("login",tempLogin);
			return "home-page";
		}
		model.addAttribute("noMatch",true);
		return "login-page";
	}

}
