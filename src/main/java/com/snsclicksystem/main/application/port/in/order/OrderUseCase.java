package com.snsclicksystem.main.application.port.in.order;

import com.snsclicksystem.main.adapter.in.order.dto.RequestOrder;
import com.snsclicksystem.main.application.port.in.order.exception.ApiAmountNotEnoughException;
import com.snsclicksystem.main.application.port.in.order.exception.CreateOrderFailException;
import com.snsclicksystem.main.application.port.in.order.exception.UserAmountNotEnoughException;
import com.snsclicksystem.main.domain.order.SnsOrder;

public interface OrderUseCase {

	SnsOrder createOrder(RequestOrder order) throws CreateOrderFailException;
}
