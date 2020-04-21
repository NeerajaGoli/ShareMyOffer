package com.neeraja.ShareMyOffer.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.neeraja.ShareMyOffer.entities.Address;
import com.neeraja.ShareMyOffer.entities.User;
import com.neeraja.ShareMyOffer.entities.UserOffer;
import com.neeraja.ShareMyOffer.services.AddressService;
import com.neeraja.ShareMyOffer.services.UserService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/home")
@Slf4j
public class HomeController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private AddressService addressService;
	
	@GetMapping("/")
	public String home() {
		User user = userService.findById(1);
		Address address = addressService.findByUser(user);
		List<UserOffer> userOffers = user.getUserOffers();
		for(UserOffer userOffer : userOffers)
			log.info(userOffer.getOffer().getName());
		log.info(address.getState());
		return "home-page";
	}
}
