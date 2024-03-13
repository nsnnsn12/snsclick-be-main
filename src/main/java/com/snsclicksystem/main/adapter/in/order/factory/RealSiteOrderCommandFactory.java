package com.snsclicksystem.main.adapter.in.order.factory;

import com.snsclicksystem.main.adapter.in.order.dto.RequestOrder;
import com.snsclicksystem.main.adapter.out.api.order.OrderApi;
import com.snsclicksystem.main.adapter.out.api.order.realsite.RealSiteClient;
import com.snsclicksystem.main.adapter.out.api.order.realsite.command.DefaultOrderCommand;
import com.snsclicksystem.main.adapter.out.api.order.realsite.dto.DefaultOrderDto;
import com.snsclicksystem.main.domain.consumer.OrderCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * 사용자의 요청을 받아 Real site에 맞는 주문을 생성하는 팩토리
 */
@Component
@RequiredArgsConstructor
public class RealSiteOrderCommandFactory implements OrderCommandFactory {
    private final OrderApi<RealSiteClient, Integer> orderApi;
    @Override
    public OrderCommand createOrderCommand(RequestOrder order) {
        /* TODO
            * 1. request order data validation 필요
            * 2. 조건에 따른 command 생성 필요
         */
        return new DefaultOrderCommand(orderApi, createDefaultOrderDto(order));
    }

    private DefaultOrderDto createDefaultOrderDto(RequestOrder order){
        //TODO need to implement
        return new DefaultOrderDto();
    }
}
