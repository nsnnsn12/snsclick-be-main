package com.snsclicksystem.main.application.service.order;

import com.snsclicksystem.main.application.port.out.api.order.RequestOrderApi;
import com.snsclicksystem.main.application.port.out.api.order.exception.NotEnoughApiAmountException;
import com.snsclicksystem.main.domain.consumer.Consumer;
import com.snsclicksystem.main.domain.consumer.exception.NotEnoughConsumerAmountException;
import com.snsclicksystem.main.domain.item.SnsItem;
import org.springframework.stereotype.Service;

import com.snsclicksystem.main.application.port.in.order.OrderUseCase;
import com.snsclicksystem.main.application.port.out.api.order.OrderApi;
import com.snsclicksystem.main.application.port.out.persistence.order.OrderRepository;
import com.snsclicksystem.main.domain.order.Order;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService implements OrderUseCase{
	
	private final OrderRepository orderRepository;
	private final OrderApi orderApi;

	@Override
	public Order createOrder(SnsItem item) throws NotEnoughApiAmountException, NotEnoughConsumerAmountException {
		//TODO need to implement for getting consumer
		Consumer consumer = new Consumer();
		Order order = consumer.order(item);
		orderApi.order(new RequestOrderApi(order));
		return orderRepository.save(order).orElseThrow(()->new RuntimeException("Fail to save order"));
	}

}
