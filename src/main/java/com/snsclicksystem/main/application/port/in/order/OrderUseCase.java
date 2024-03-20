package com.snsclicksystem.main.application.port.in.order;

import com.snsclicksystem.main.application.service.order.OrderFactory;
import com.snsclicksystem.main.domain.order.dto.OrderedInfo;
import com.snsclicksystem.main.domain.order.exception.NotEnoughApiAmountException;
import com.snsclicksystem.main.domain.order.exception.NotEnoughConsumerAmountException;

public interface OrderUseCase {
	OrderedInfo createOrder(OrderFactory orderCommandFactory, Long itemId) throws NotEnoughApiAmountException, NotEnoughConsumerAmountException;
}
