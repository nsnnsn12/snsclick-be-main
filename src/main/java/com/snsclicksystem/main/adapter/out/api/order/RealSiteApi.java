package com.snsclicksystem.main.adapter.out.api.order;

import com.snsclicksystem.main.application.port.out.api.order.RequestOrderApi;
import com.snsclicksystem.main.application.port.out.api.order.ResponseOrderApi;
import org.springframework.context.annotation.Configuration;

import com.snsclicksystem.main.application.port.out.api.order.OrderApi;

@Configuration
public class RealSiteApi implements OrderApi{

	@Override
	public ResponseOrderApi order(RequestOrderApi requestOrderApi) {
		if(canOrder()){
			//TODO need to implements
		}
		return null;
	}

	private boolean canOrder(){
		isMoneyEnough();
		//TODO need to add more validation
		return true;
	}

	private void isMoneyEnough(){
		//TODO implement => if(apiAmount < orderPrice) throw new NotEnoughApiAmountException();
	}



}
