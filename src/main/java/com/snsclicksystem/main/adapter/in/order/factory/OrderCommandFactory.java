package com.snsclicksystem.main.adapter.in.order.factory;

import com.snsclicksystem.main.adapter.in.order.dto.RequestOrder;
import com.snsclicksystem.main.domain.consumer.OrderCommand;

/**
 * 사용자의 요청을 받아 주문을 생성하는 팩토리
 */
public interface OrderCommandFactory {
    OrderCommand createOrderCommand(RequestOrder order);
}
