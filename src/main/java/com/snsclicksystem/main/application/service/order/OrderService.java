package com.snsclicksystem.main.application.service.order;

import com.snsclicksystem.main.application.port.out.persistence.item.ItemRepository;
import com.snsclicksystem.main.application.port.out.persistence.transaction_history.TransactionHistoryRepository;
import com.snsclicksystem.main.domain.item.Item;
import com.snsclicksystem.main.domain.member.Member;
import com.snsclicksystem.main.domain.order.dto.OrderedInfoDto;
import com.snsclicksystem.main.domain.order.exception.NotEnoughApiAmountException;
import com.snsclicksystem.main.domain.order.exception.NotEnoughConsumerAmountException;
import com.snsclicksystem.main.domain.transaction_history.TransactionHistory;
import org.springframework.stereotype.Service;

import com.snsclicksystem.main.application.port.in.order.OrderUseCase;
import com.snsclicksystem.main.application.port.out.persistence.order.OrderRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService implements OrderUseCase{
	
	private final OrderRepository orderRepository;
	private final ItemRepository itemRepository;
	private final TransactionHistoryRepository transactionHistoryRepository;

	@Override
	public OrderedInfoDto createOrder(OrderFactory orderCommandFactory, Long itemId) throws NotEnoughApiAmountException, NotEnoughConsumerAmountException {

		//TODO need to implement finding member
		Member member = Member.builder().build();
		Item item = itemRepository.findById(itemId).orElseThrow(() -> new RuntimeException("Fail to find item"));
		OrderedInfoDto orderedInfoDto = orderCommandFactory
				.getOrder(InternalParameterForOrder.builder().member(member).item(item).build())
				.execute();

		TransactionHistory savedTransactionHistory = transactionHistoryRepository.save(orderedInfoDto.getTransactionHistory());
		orderedInfoDto.setTransactionHistory(savedTransactionHistory);
		return orderRepository.save(orderedInfoDto);
	}

}
