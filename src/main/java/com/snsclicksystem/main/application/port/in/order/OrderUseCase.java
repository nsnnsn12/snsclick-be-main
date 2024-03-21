package com.snsclicksystem.main.application.port.in.order;

import com.snsclicksystem.main.application.service.order.OrderFactory;
import com.snsclicksystem.main.domain.order.dto.OrderedInfoDto;
import com.snsclicksystem.main.domain.order.exception.NotEnoughApiAmountException;
import com.snsclicksystem.main.domain.order.exception.NotEnoughConsumerAmountException;

public interface OrderUseCase {
	OrderedInfoDto createOrder(OrderFactory orderCommandFactory, Long itemId) throws NotEnoughApiAmountException, NotEnoughConsumerAmountException;
}
