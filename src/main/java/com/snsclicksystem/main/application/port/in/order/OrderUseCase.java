package com.snsclicksystem.main.application.port.in.order;

import com.snsclicksystem.main.domain.consumer.OrderCommand;
import com.snsclicksystem.main.domain.consumer.exception.NotEnoughApiAmountException;
import com.snsclicksystem.main.domain.consumer.exception.NotEnoughConsumerAmountException;
import com.snsclicksystem.main.domain.item.SnsItem;
import com.snsclicksystem.main.domain.order.Order;

public interface OrderUseCase {
	//TODO 주문 외에 비즈니스 로직으로 파라미터가 더 필요한 경우 따로 dto 만들어 추가
	Order createOrder(OrderCommand orderCommand) throws NotEnoughApiAmountException, NotEnoughConsumerAmountException;
}
