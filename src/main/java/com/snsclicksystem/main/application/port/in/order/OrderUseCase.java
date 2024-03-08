package com.snsclicksystem.main.application.port.in.order;

import com.snsclicksystem.main.application.port.out.api.order.exception.NotEnoughApiAmountException;
import com.snsclicksystem.main.domain.consumer.exception.NotEnoughConsumerAmountException;
import com.snsclicksystem.main.domain.item.SnsItem;
import com.snsclicksystem.main.domain.order.Order;

public interface OrderUseCase {
	Order createOrder(SnsItem item) throws NotEnoughApiAmountException, NotEnoughConsumerAmountException;
}
