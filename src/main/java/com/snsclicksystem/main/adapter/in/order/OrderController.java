package com.snsclicksystem.main.adapter.in.order;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.snsclicksystem.main.adapter.in.common.NoCreateException;
import com.snsclicksystem.main.adapter.in.common.NoSearchException;
import com.snsclicksystem.main.adapter.in.item.dto.ResponseItem;
import com.snsclicksystem.main.adapter.in.order.dto.RequestOrder;
import com.snsclicksystem.main.adapter.in.order.dto.ResponseOrder;
import com.snsclicksystem.main.application.port.in.item.ItemNotFoundException;
import com.snsclicksystem.main.application.port.in.order.OrderUseCase;
import com.snsclicksystem.main.application.port.in.order.exception.ApiAmountNotEnoughException;
import com.snsclicksystem.main.application.port.in.order.exception.CreateOrderFailException;
import com.snsclicksystem.main.application.port.in.order.exception.UserAmountNotEnoughException;
import com.snsclicksystem.main.util.modelmapper.ObjectMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class OrderController {

	private final OrderUseCase orderUseCase;
	private final ObjectMapper objectMapper;

	@PostMapping("/orders")
	public ResponseEntity<ResponseOrder> orders(@RequestBody @Validated RequestOrder order) {
		try {
			return new ResponseEntity<>(objectMapper.convert(orderUseCase.createOrder(order), ResponseOrder.class),
					HttpStatus.OK);
		} catch (CreateOrderFailException e) {
			throw new NoCreateException(e.getMessage());
		}
	}

}
