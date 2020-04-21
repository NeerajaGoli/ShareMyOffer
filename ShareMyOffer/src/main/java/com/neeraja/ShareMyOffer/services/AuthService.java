package com.neeraja.ShareMyOffer.services;

public interface AuthService
{
	
	
	public boolean sendOtp(String mobileNumber);
	public boolean verifyOtp(String mobileNumber,String Otp);
}
