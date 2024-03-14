package com.snsclicksystem.main.adapter.in.order.factory;

import com.snsclicksystem.main.adapter.in.order.dto.RequestOrder;
import com.snsclicksystem.main.adapter.out.api.order.realsite.RealSiteClient;
import com.snsclicksystem.main.adapter.out.api.order.realsite.command.DefaultOrderCommand;
import com.snsclicksystem.main.adapter.out.api.order.realsite.dto.DefaultOrderDto;
import com.snsclicksystem.main.application.service.order.InternalParameterForOrder;
import com.snsclicksystem.main.application.service.order.OrderCommandFactory;
import com.snsclicksystem.main.domain.order.Order;
import lombok.RequiredArgsConstructor;

/**
 * 사용자의 요청을 받아 Real site에 맞는 주문을 생성하는 팩토리
 */
@RequiredArgsConstructor
public class RealSiteOrderCommandFactory implements OrderCommandFactory {
    private final RequestOrder order;
    protected final RealSiteClient realSiteClient;
    @Override
    public Order getCharge(InternalParameterForOrder parameter) {
        //TODO 분기를 기준으로 각각의 command 생성 필요
        return getDefaultOrderCommand(parameter);
    }

    private Order getDefaultOrderCommand(InternalParameterForOrder parameter){
        return new DefaultOrderCommand(realSiteClient, parameter, new DefaultOrderDto());
    }
}
