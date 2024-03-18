package com.snsclicksystem.main.application.service.order;

import com.snsclicksystem.main.domain.order.exception.NotEnoughApiAmountException;
import com.snsclicksystem.main.domain.order.exception.NotEnoughConsumerAmountException;
import com.snsclicksystem.main.domain.member.Member;
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
	public Order createOrder(OrderFactory orderCommandFactory) throws NotEnoughApiAmountException, NotEnoughConsumerAmountException {

		//TODO internalParameterForOrder에 apiKey, action, serviceId, orderType, snsItem을 넣어서 생성
		Member member = Member.builder().build();
		Order order = orderCommandFactory.getOrder(InternalParameterForOrder.builder().member(member).build());
		return orderRepository.save(order.execute()).orElseThrow(()->new RuntimeException("Fail to save order"));
	}

}
