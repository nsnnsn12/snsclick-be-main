package com.snsclicksystem.main.application.service.order;

import org.springframework.stereotype.Service;

import com.snsclicksystem.main.adapter.in.order.dto.RequestOrder;
import com.snsclicksystem.main.application.port.in.order.OrderUseCase;
import com.snsclicksystem.main.application.port.in.order.exception.ApiAmountNotEnoughException;
import com.snsclicksystem.main.application.port.in.order.exception.CreateOrderFailException;
import com.snsclicksystem.main.application.port.in.order.exception.UserAmountNotEnoughException;
import com.snsclicksystem.main.application.port.out.api.order.OrderApi;
import com.snsclicksystem.main.application.port.out.persistence.member.MemberRepository;
import com.snsclicksystem.main.application.port.out.persistence.order.OrderRepository;
import com.snsclicksystem.main.domain.order.Order;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService implements OrderUseCase{
	
	private final MemberRepository memberRepository;
	private final OrderRepository orderRepository;
	private final OrderApi orderApi;

	@Override
	public Order createOrder(RequestOrder order) throws CreateOrderFailException {
		int userAmount = memberRepository.findTotAmountById(order.getMemberId());
		int apiAmount = orderApi.getChargeAmount();
		int orderPrice = order.getOrderPrice();
		
		if(userAmount < orderPrice) {
			throw new UserAmountNotEnoughException();
		}
		
		if(apiAmount < orderPrice) {
			throw new ApiAmountNotEnoughException();
		}
		
		return orderRepository.save(order).orElseThrow(CreateOrderFailException::new);
	}

}
