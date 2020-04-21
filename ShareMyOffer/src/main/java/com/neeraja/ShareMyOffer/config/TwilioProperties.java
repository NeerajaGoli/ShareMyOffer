package com.neeraja.ShareMyOffer.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix="twilio")
@PropertySource("classpath:application.properties")
public class TwilioProperties {

	@Value("${twilio.accSid}")
	private  String accSid;
	
	@Value("${twilio.authToken}")
	private  String authToken;

	
	@Value("${twilio.serviceSid}")
	private  String serviceSid;

	
	public String getAccSid() {
		return accSid;
	}


	public void setAccSid(String accSid) {
		this.accSid = accSid;
	}


	public String getAuthToken() {
		return authToken;
	}


	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}


	public String getServiceSid() {
		return serviceSid;
	}


	public void setServiceSid(String serviceSid) {
		this.serviceSid = serviceSid;
	}

	
}
