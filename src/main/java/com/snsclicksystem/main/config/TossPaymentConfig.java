package com.snsclicksystem.main.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;

@Configuration
@Getter
public class TossPaymentConfig {
	
	public static final String URL = "https://api.tosspayments.com/v1/paymenst";
	
	@Value("${payment.toss.test_client_api_key}")
	private static String testClientApiKey;
	
	@Value("${payment.toss.test_secret_api_key}")
	private String testSecretApiKey;
	
	@Value("${payment.toss.success_url}")
	private String successUrl;
	
	@Value("${payment.toss.fail_url}")
	private String failUrl;
}
