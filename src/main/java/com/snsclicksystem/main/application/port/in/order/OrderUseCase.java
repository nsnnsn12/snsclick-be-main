package com.snsclicksystem.main.application.port.in.order;

import com.snsclicksystem.main.application.service.order.OrderFactory;
import com.snsclicksystem.main.domain.order.exception.NotEnoughApiAmountException;
import com.snsclicksystem.main.domain.order.exception.NotEnoughConsumerAmountException;
import com.snsclicksystem.main.domain.order.Order;

public interface OrderUseCase {
	Order createOrder(OrderFactory orderCommandFactory) throws NotEnoughApiAmountException, NotEnoughConsumerAmountException;
}
