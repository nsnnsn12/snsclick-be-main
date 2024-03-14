package com.snsclicksystem.main.application.port.in.order;

import com.snsclicksystem.main.application.service.order.OrderCommandFactory;
import com.snsclicksystem.main.domain.consumer.exception.NotEnoughApiAmountException;
import com.snsclicksystem.main.domain.consumer.exception.NotEnoughConsumerAmountException;
import com.snsclicksystem.main.domain.order.Order;

public interface OrderUseCase {
	Order createOrder(OrderCommandFactory orderCommandFactory) throws NotEnoughApiAmountException, NotEnoughConsumerAmountException;
}
