package com.neeraja.ShareMyOffer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neeraja.ShareMyOffer.services.AuthService;
import com.neeraja.ShareMyOffer.services.TwilioAuthServiceImpl;

@RestController
public class AuthController {

	@Autowired
	AuthService authService;
	
	@RequestMapping(value="/{mobileNumber}")
	public String sendOtp(@PathVariable String mobileNumber)
	{
		if(authService.sendOtp(mobileNumber))
		{
			return "Otp sent SuccessFully";
		}
		else
		{
			return "Failed to send Otp";
		}
	}
	
	@RequestMapping(value="/{mobileNumber}/{otp}")
	public String verifyOtp(@PathVariable String mobileNumber,@PathVariable String otp)
	{
		if(authService.verifyOtp(mobileNumber, otp))
		{
			return "Otp verified Successfully";
		}
		else
		{
			return "Invalid Otp";
		}
	}
}
