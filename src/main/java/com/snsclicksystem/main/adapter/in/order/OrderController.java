package com.snsclicksystem.main.adapter.in.order;

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
import com.snsclicksystem.main.application.port.in.order.exception.CreateOrderFailException;
import com.snsclicksystem.main.util.modelmapper.ObjectMapper;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

	private final OrderUseCase orderUseCase;
	private final ObjectMapper objectMapper;

	@PostMapping("/")
	public ResponseEntity<ResponseOrder> orders(@RequestBody @Validated RequestOrder order) {
		try {
			return new ResponseEntity<>(objectMapper.convert(orderUseCase.createOrder(order), ResponseOrder.class),
					HttpStatus.OK);
		} catch (CreateOrderFailException e) {
			throw new NoCreateException(e.getMessage());
		}
	}

	//TODO 컨트롤러 부분은 우리가 사용자에게 제공할 기능이 무엇인지 그리고 사용자, 즉 프론트로부터 어떤 정보를 받을지 정의한 다음에 작성해야 할 듯

}
