package com.snsclicksystem.main.application.port.out.persistence.order;

import java.util.Optional;

import com.snsclicksystem.main.adapter.out.api.order.dto.OrderedInfo;
import com.snsclicksystem.main.domain.order.Order;

public interface OrderRepository {

	Optional<Order> save(OrderedInfo order);

}
