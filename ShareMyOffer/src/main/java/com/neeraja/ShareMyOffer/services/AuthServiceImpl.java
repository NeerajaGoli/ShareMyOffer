package com.neeraja.ShareMyOffer.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neeraja.ShareMyOffer.config.TwilioProperties;
import com.twilio.Twilio;
import com.twilio.exception.ApiException;
import com.twilio.rest.verify.v2.service.Verification;
import com.twilio.rest.verify.v2.service.VerificationCheck;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AuthServiceImpl implements AuthService {

	private TwilioProperties twilioProps;

	@Autowired
	public AuthServiceImpl(TwilioProperties twilioProps) {
		this.twilioProps = twilioProps;
	}

	@Override
	public Boolean sendOtp(String mobileNumber) {


		Twilio.init(twilioProps.getAccSid(), twilioProps.getAuthToken());
		try {
			Verification verification = Verification.creator(twilioProps.getServiceSid(), mobileNumber, "sms").create();
			log.info("Otp Sent Successfully");
			return true;
		}

		catch (ApiException exception) {
			log.error("Invalid phone Number");
			log.error(exception.getMessage());
			return false;
		}

	}

	@Override
	public Boolean verifyOtp(String mobileNumber, String Otp) {


		Twilio.init(twilioProps.getAccSid(), twilioProps.getAuthToken());
		try {
			VerificationCheck verificationCheck = VerificationCheck.creator(twilioProps.getServiceSid(), Otp)
					.setTo(mobileNumber).create();

			if (verificationCheck.getStatus().equals("approved")) {
				log.info("Otp verified successfully");

				return true;
			} else {
				log.error("Invalid otp entered");
				return false;
			}
		} catch (Exception exception) {
			log.error(exception.getMessage());
			return false;
		}

	}

}