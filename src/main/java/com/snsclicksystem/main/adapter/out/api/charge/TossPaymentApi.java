package com.snsclicksystem.main.adapter.out.api.charge;

import org.springframework.context.annotation.Configuration;

import com.snsclicksystem.main.application.port.out.api.charge.ChargeApi;
import com.snsclicksystem.main.config.TossPaymentConfig;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class TossPaymentApi implements ChargeApi{
	
	private final TossPaymentConfig tossPaymentConfig;
	
	@Override
	public String getTestClientApiKey() {
		return this.tossPaymentConfig.getTestSecretApiKey();
	}
	
	@Override
	public String getTestSecretApiKey() {
		return this.tossPaymentConfig.getTestSecretApiKey();
	}
	
	@Override
	public String getSuccessUrl() {
		return this.tossPaymentConfig.getSuccessUrl();
	}
	
	@Override
	public String getFailUrl() {
		return this.tossPaymentConfig.getFailUrl();
	}
	

}
