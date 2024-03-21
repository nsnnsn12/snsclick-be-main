package com.snsclicksystem.main.adapter.in.order;

import com.snsclicksystem.main.adapter.in.order.factory.RealSiteOrderFactory;
import com.snsclicksystem.main.adapter.out.api.order.realsite.RealSiteClient;
import com.snsclicksystem.main.adapter.out.persistence.real_site.RealSiteRepository;
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

@RestController
@RequestMapping("/order")
public class OrderController {

	private final OrderUseCase orderUseCase;
	private final ObjectMapper objectMapper;
	private final RealSiteClient realSiteClient;
	private final String REAL_SITE_API_KEY;
	private final RealSiteRepository realSiteRepository;

	public OrderController(OrderUseCase orderUseCase
			, ObjectMapper objectMapper
			, RealSiteClient realSiteClient
			, @Value("${real-site.api-key}") String real_site_api_key
			, RealSiteRepository realSiteRepository) {
		this.orderUseCase = orderUseCase;
		this.objectMapper = objectMapper;
		this.realSiteClient = realSiteClient;
		REAL_SITE_API_KEY = real_site_api_key;
		this.realSiteRepository = realSiteRepository;
	}

	@PostMapping("/")
	public ResponseEntity<ResponseOrder> orders(@RequestBody @Validated RequestOrder order) {
		try {
			return new ResponseEntity<>(objectMapper.convert(orderUseCase.createOrder(new RealSiteOrderFactory(order, realSiteClient, REAL_SITE_API_KEY, realSiteRepository), order.getItemId()), ResponseOrder.class),
					HttpStatus.OK);
		} catch (NotEnoughApiAmountException | NotEnoughConsumerAmountException e) {
			throw new NoCreateException(e.getMessage());
		}
	}
}
