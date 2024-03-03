package com.snsclicksystem.main.adapter.out.api.order;

import org.springframework.context.annotation.Configuration;

import com.snsclicksystem.main.application.port.out.api.order.OrderApi;

@Configuration
public class RealSiteApi implements OrderApi{

	@Override
	public int getChargeAmount() {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
