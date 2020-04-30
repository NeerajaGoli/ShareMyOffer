package com.neeraja.ShareMyOffer.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.neeraja.ShareMyOffer.dto.AddressDTO;
import com.neeraja.ShareMyOffer.dto.OfferDTO;
import com.neeraja.ShareMyOffer.entities.Address;
import com.neeraja.ShareMyOffer.entities.Offer;
import com.neeraja.ShareMyOffer.services.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.neeraja.ShareMyOffer.dto.UserDTO;
import com.neeraja.ShareMyOffer.dto.UserOfferDTO;
import com.neeraja.ShareMyOffer.services.UserOfferService;

@Controller
@RequestMapping("/home")
public class HomeController {
	
	@Autowired
	private UserOfferService userOfferService;

	@Autowired
	private OfferService offerService;

	@GetMapping("/")
	public String home(Model theModel,HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		UserDTO userDTO = (UserDTO)session.getAttribute("user");
		session.setAttribute("user", userDTO);
		theModel.addAttribute("user", userDTO);
		List<UserOfferDTO> userOffersDTO = userOfferService.findMyOffers(userDTO,"posted");
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
		OfferDTO offerDTO = new OfferDTO();
		theModel.addAttribute("offer",offerDTO);
		return "offers";
	}

	@PostMapping("/")
	public String home(@ModelAttribute("offer")OfferDTO offerDTO,HttpServletRequest request) {
		offerDTO.setStatus("Active");
		HttpSession session = request.getSession(true);
		UserDTO userDTO = (UserDTO)session.getAttribute("user");
		offerDTO.setAddress(userDTO.getAddress());
		OfferDTO offerDTO1 = offerService.save(offerDTO);
		userOfferService.save(userDTO,offerDTO1);
		return "redirect:/home/yourOffers";
	}

	@GetMapping("/contact")
	public String contact() {
		return "contact";
	}

	@GetMapping("/profile")
	public String profile(Model theModel,HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		UserDTO userDTO = (UserDTO)session.getAttribute("user");
		Address address = userDTO.getAddress();
		theModel.addAttribute("user",userDTO);
		theModel.addAttribute("address",address);
		return "profile";
	}

	@GetMapping("/logout")
	public String logout() {
		return "redirect:/login/showMyLoginPage";
	}

}
