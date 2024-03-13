package com.snsclicksystem.main.adapter.out.api.order.realsite.command;

import com.snsclicksystem.main.adapter.out.api.order.dto.OrderedInfo;
import com.snsclicksystem.main.adapter.out.api.order.realsite.RealSiteClient;
import com.snsclicksystem.main.adapter.out.api.order.realsite.RealSiteOrderDto;
import com.snsclicksystem.main.adapter.out.api.order.OrderApi;
import com.snsclicksystem.main.domain.consumer.exception.NotEnoughApiAmountException;
import com.snsclicksystem.main.domain.consumer.Consumer;
import com.snsclicksystem.main.domain.consumer.OrderCommand;
import com.snsclicksystem.main.domain.order.Order;
import lombok.RequiredArgsConstructor;

/**
 * Real site에 주문 요청을 하기 위한 정보를 가지고 있는 command
 */
@RequiredArgsConstructor
public abstract class RealSiteOrderCommand implements OrderCommand {
    protected final OrderApi<RealSiteClient, Integer> orderApi;
    protected final RealSiteOrderDto realSiteOrderDto;

    @Override
    public abstract Order execute(Consumer consumer) throws NotEnoughApiAmountException;

    protected Order toOrder(OrderedInfo orderedInfo){
        //TODO need to implement
        return null;
    }
}
