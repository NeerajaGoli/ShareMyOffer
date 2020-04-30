package com.neeraja.ShareMyOffer.services;

public interface AuthService {

	// to send OTP/token to user
    public Boolean sendOtp(String mobileNumber);

    // to verify OTP/token entered by user
    public Boolean verifyOtp(String mobileNumber,String otp);
    
}