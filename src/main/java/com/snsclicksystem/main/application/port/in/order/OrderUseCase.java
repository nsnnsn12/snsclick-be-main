package com.snsclicksystem.main.application.port.in.order;

import com.snsclicksystem.main.adapter.in.order.dto.RequestOrder;
import com.snsclicksystem.main.application.port.in.order.exception.CreateOrderFailException;
import com.snsclicksystem.main.domain.order.Order;

public interface OrderUseCase {

	Order createOrder(RequestOrder order) throws CreateOrderFailException;
}
