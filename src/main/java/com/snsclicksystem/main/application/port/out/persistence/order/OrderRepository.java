package com.snsclicksystem.main.application.port.out.persistence.order;
import com.snsclicksystem.main.domain.order.dto.OrderedInfoDto;

public interface OrderRepository {

	OrderedInfoDto save(OrderedInfoDto order);

}
