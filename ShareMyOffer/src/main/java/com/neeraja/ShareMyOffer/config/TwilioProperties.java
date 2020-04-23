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
public class TwilioProperties 
{

	
	private  String accSid;
	private  String authToken;
	private  String serviceSid;

	
}
