package com.snsclicksystem.main.adapter.in.order;

import com.snsclicksystem.main.adapter.in.order.factory.RealSiteOrderFactory;
import com.snsclicksystem.main.adapter.out.api.order.realsite.RealSiteClient;
import com.snsclicksystem.main.domain.order.exception.NotEnoughApiAmountException;
import com.snsclicksystem.main.domain.order.exception.NotEnoughConsumerAmountException;
import org.springframework.beans.factory.annotation.Value;
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
	@Value("${real-site.api-key}")
	private final String REAL_SITE_API_KEY;

	@PostMapping("/")
	public ResponseEntity<ResponseOrder> orders(@RequestBody @Validated RequestOrder order) {
		try {
			return new ResponseEntity<>(objectMapper.convert(orderUseCase.createOrder(new RealSiteOrderFactory(order, realSiteClient, REAL_SITE_API_KEY)), ResponseOrder.class),
					HttpStatus.OK);
		} catch (NotEnoughApiAmountException | NotEnoughConsumerAmountException e) {
			throw new NoCreateException(e.getMessage());
		}
	}
}
