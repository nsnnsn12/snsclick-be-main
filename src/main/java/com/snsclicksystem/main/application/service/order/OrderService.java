package com.snsclicksystem.main.application.service.order;

import com.snsclicksystem.main.domain.consumer.OrderCommand;
import com.snsclicksystem.main.domain.consumer.exception.NotEnoughApiAmountException;
import com.snsclicksystem.main.domain.consumer.Consumer;
import com.snsclicksystem.main.domain.consumer.exception.NotEnoughConsumerAmountException;
import org.springframework.stereotype.Service;

import com.snsclicksystem.main.application.port.in.order.OrderUseCase;
import com.snsclicksystem.main.application.port.out.persistence.order.OrderRepository;
import com.snsclicksystem.main.domain.order.Order;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService implements OrderUseCase{
	
	private final OrderRepository orderRepository;

	@Override
	public Order createOrder(OrderCommand orderCommand) throws NotEnoughApiAmountException, NotEnoughConsumerAmountException {
		/* TODO
		 * 1. Consumer 가져오는 로직 필요
		 * 2. 해외 api에 주문 요청하는 것 외에 필요한 비즈니스 로직 작성 필요
		 * ex) 주문 후 주문 정보를 db에 저장하는 것 등등
		 */
		Consumer consumer = new Consumer();
		Order order = consumer.order(orderCommand);
		return orderRepository.save(order).orElseThrow(()->new RuntimeException("Fail to save order"));
	}

}
