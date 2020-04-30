package com.neeraja.ShareMyOffer.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "twilio")
public class TwilioProperties {

	private String accSid;
	private String authToken;
	private String serviceSid;

}