package com.neeraja.ShareMyOffer.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.neeraja.ShareMyOffer.dto.OfferDTO;
import com.neeraja.ShareMyOffer.dto.UserDTO;
import com.neeraja.ShareMyOffer.dto.UserOfferDTO;
import com.neeraja.ShareMyOffer.services.OfferService;
import com.neeraja.ShareMyOffer.services.UserOfferService;
import com.neeraja.ShareMyOffer.services.UserService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/user")
@Slf4j
public class UserController {

	@Autowired
	private UserOfferService userOfferService;
	
	@Autowired
	private OfferService offerService;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/acceptOffer")
	public String acceptOffer(@RequestParam("offerId") int offerId,Model theModel,HttpServletRequest request) {
		HttpSession session = request.getSession();
		UserDTO userDTO = (UserDTO)session.getAttribute("user");
		session.setAttribute("user", userDTO);
		theModel.addAttribute("user", userDTO);
		OfferDTO offerDTO = offerService.findById(offerId);
		log.info(userDTO.toString());
		log.info(offerDTO.toString());
		userOfferService.save(userDTO,offerDTO);
		List<UserOfferDTO> userOffersDTO = userOfferService.findByPurpose("posted");
		theModel.addAttribute("offers", userOffersDTO);
		return "home-page";
	}

}
