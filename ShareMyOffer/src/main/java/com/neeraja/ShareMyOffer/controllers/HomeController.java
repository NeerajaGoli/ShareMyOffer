package com.neeraja.ShareMyOffer.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.neeraja.ShareMyOffer.dto.UserDTO;
import com.neeraja.ShareMyOffer.dto.UserOfferDTO;
import com.neeraja.ShareMyOffer.services.UserOfferService;

@Controller
@RequestMapping("/home")
public class HomeController {
	
	@Autowired
	private UserOfferService userOfferService;
	
	@GetMapping("/")
	public String home(Model theModel,HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		UserDTO userDTO = (UserDTO)session.getAttribute("user");
		session.setAttribute("user", userDTO);
		theModel.addAttribute("user", userDTO);
		List<UserOfferDTO> userOffersDTO = userOfferService.findByPurpose("posted");
		theModel.addAttribute("offers", userOffersDTO);
		return "home-page";
	}
	
	@RequestMapping("/yourOffers")
	public String yourOffers(Model theModel,HttpServletRequest request) {
		HttpSession session = request.getSession();
		UserDTO userDTO = (UserDTO)session.getAttribute("user");
		theModel.addAttribute("user", userDTO);
		List<UserOfferDTO> userOffersDTO = userOfferService.findByUserAndPurpose(userDTO,"posted");
		theModel.addAttribute("offers", userOffersDTO);
		return "offers";
	}
}
