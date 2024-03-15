package com.snsclicksystem.main.application.service.order;

import com.snsclicksystem.main.domain.order.exception.NotEnoughApiAmountException;
import com.snsclicksystem.main.domain.order.exception.NotEnoughConsumerAmountException;
import com.snsclicksystem.main.domain.member.MemberInfo;
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
		/* TODO
		 * 1. Consumer 가져오는 로직 필요
		 * 2. 해외 api에 주문 요청하는 것 외에 필요한 비즈니스 로직 작성 필요
		 * ex) 주문 후 주문 정보를 db에 저장하는 것 등등
		 */
		//factory를 통해 command를 생성한다.
		//internal parameter 클래스를 만들어 내부에서 조회한 정보를 담아서 command를 만들 때 사용한다.
		//consumer가 charge하는 방향에서 벋어나서 order 자체가 실행 로직을 담고 있는 팩토리 메서드로 실행한다.
		MemberInfo member = MemberInfo.builder().build();
		Order order = orderCommandFactory.getCharge(InternalParameterForOrder.builder().member(member).build());
		return orderRepository.save(order.execute()).orElseThrow(()->new RuntimeException("Fail to save order"));
	}

}
