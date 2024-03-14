package com.snsclicksystem.main.adapter.in.order;

import com.snsclicksystem.main.adapter.in.order.factory.RealSiteOrderCommandFactory;
import com.snsclicksystem.main.adapter.out.api.order.realsite.RealSiteClient;
import com.snsclicksystem.main.domain.consumer.exception.NotEnoughApiAmountException;
import com.snsclicksystem.main.domain.consumer.exception.NotEnoughConsumerAmountException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.snsclicksystem.main.adapter.in.common.NoCreateException;
import com.snsclicksystem.main.adapter.in.order.dto.RequestOrder;
import com.snsclicksystem.main.adapter.in.order.dto.ResponseOrder;
import com.snsclicksystem.main.application.port.in.order.OrderUseCase;
import com.snsclicksystem.main.util.modelmapper.ObjectMapper;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

	private final OrderUseCase orderUseCase;
	private final ObjectMapper objectMapper;
	private final RealSiteClient realSiteClient;

	@PostMapping("/")
	public ResponseEntity<ResponseOrder> orders(@RequestBody @Validated RequestOrder order) {
		try {
			//TODO order type에 따라 분기가 되든 뭐가 되든 해야 함
			return new ResponseEntity<>(objectMapper.convert(orderUseCase.createOrder(new RealSiteOrderCommandFactory(order, realSiteClient)), ResponseOrder.class),
					HttpStatus.OK);
		} catch (NotEnoughApiAmountException | NotEnoughConsumerAmountException e) {
			throw new NoCreateException(e.getMessage());
		}
	}
}
