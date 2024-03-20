package com.snsclicksystem.main.application.port.out.persistence.order;
import com.snsclicksystem.main.domain.order.dto.OrderedInfo;

public interface OrderRepository {

	OrderedInfo save(OrderedInfo order);

}
