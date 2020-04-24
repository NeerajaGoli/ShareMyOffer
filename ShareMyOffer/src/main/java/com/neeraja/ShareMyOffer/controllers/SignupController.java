package com.neeraja.ShareMyOffer.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.neeraja.ShareMyOffer.dto.AddressDTO;
import com.neeraja.ShareMyOffer.dto.UserDTO;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/signup")
@Slf4j
public class SignupController {

	@GetMapping("/showMySignUpPage")
	public String showMySignUpPage(Model theModel) {
		UserDTO userDTO = new UserDTO();
		AddressDTO addressDTO = new AddressDTO();
		theModel.addAttribute("user", userDTO);
		theModel.addAttribute("address", addressDTO);
		return "signup-page";
	}
	
	@GetMapping("/processForm")
	public String processForm(@Valid @ModelAttribute("user") UserDTO user,
									@ModelAttribute("address") AddressDTO address,
									BindingResult theBindingResult, Model theModal) {
		log.info(user.getFirstName());
		return "signup-page";
	}
}
