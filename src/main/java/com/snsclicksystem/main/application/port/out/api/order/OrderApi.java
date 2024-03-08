package com.snsclicksystem.main.application.port.out.api.order;

import com.snsclicksystem.main.application.port.out.api.order.exception.NotEnoughApiAmountException;

public interface OrderApi {
	ResponseOrderApi order(RequestOrderApi requestOrderApi) throws NotEnoughApiAmountException;
}

