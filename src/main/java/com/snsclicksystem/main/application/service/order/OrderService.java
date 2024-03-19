package com.snsclicksystem.main.application.service.order;

import com.snsclicksystem.main.application.port.out.persistence.item.ItemRepository;
import com.snsclicksystem.main.domain.item.Item;
import com.snsclicksystem.main.domain.member.Member;
import com.snsclicksystem.main.domain.order.exception.NotEnoughApiAmountException;
import com.snsclicksystem.main.domain.order.exception.NotEnoughConsumerAmountException;
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
	private final ItemRepository itemRepository;

	@Override
	public Order createOrder(OrderFactory orderCommandFactory, Long itemId) throws NotEnoughApiAmountException, NotEnoughConsumerAmountException {

		Member member = Member.builder().build();
		Item item = itemRepository.findById(itemId).orElseThrow(() -> new RuntimeException("Fail to find item"));
		Order order = orderCommandFactory.getOrder(InternalParameterForOrder.builder().member(member).item(item).build());
		return orderRepository.save(order.execute()).orElseThrow(()->new RuntimeException("Fail to save order"));
	}

}
