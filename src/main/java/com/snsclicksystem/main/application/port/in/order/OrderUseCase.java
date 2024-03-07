package com.snsclicksystem.main.application.port.in.order;

import com.snsclicksystem.main.application.port.in.order.exception.CreateOrderFailException;
import com.snsclicksystem.main.domain.item.SnsItem;
import com.snsclicksystem.main.domain.order.Order;

public interface OrderUseCase {

	Order createOrder(SnsItem item) throws CreateOrderFailException;
}
