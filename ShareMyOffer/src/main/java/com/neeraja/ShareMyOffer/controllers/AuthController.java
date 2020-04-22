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

	LoginDTO tempLogin = new LoginDTO("srivathsa","srivathsa@123");
	
	@GetMapping("/login")
	public String loginPage() {
		return "login-page";
	}
	
	@PostMapping("/validateUser")
	public String validateUser(@ModelAttribute("login")LoginDTO login,Model model) {
		if(tempLogin.getPhone().equals(login.getPhone())&&tempLogin.getPassword().equals(login.getPassword())) {
			model.addAttribute("login",new LoginDTO());
			return "redirect:/shareMyOffer/home";
		}
		else {
			model.addAttribute("err",true);
			return "login-page";
		}
	}
	
	@GetMapping("/home")
	public String homePage() {
		return "home-page";
	}

}
