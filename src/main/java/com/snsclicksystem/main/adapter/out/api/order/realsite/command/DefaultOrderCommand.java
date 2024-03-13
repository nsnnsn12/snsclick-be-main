package com.snsclicksystem.main.adapter.out.api.order.realsite.command;

import com.snsclicksystem.main.adapter.out.api.order.realsite.RealSiteClient;
import com.snsclicksystem.main.adapter.out.api.order.realsite.RealSiteOrderDto;
import com.snsclicksystem.main.adapter.out.api.order.OrderApi;
import com.snsclicksystem.main.adapter.out.api.order.dto.OrderedInfo;
import com.snsclicksystem.main.adapter.out.api.order.realsite.dto.DefaultOrderDto;
import com.snsclicksystem.main.domain.consumer.exception.NotEnoughApiAmountException;
import com.snsclicksystem.main.domain.consumer.Consumer;
import com.snsclicksystem.main.domain.order.Order;

/**
 * Real site에 default type에 주문 요청시 필요한 작업을 가진 command
 * ex) default order 전후로 필요한 필터 등등
 */
public class DefaultOrderCommand extends RealSiteOrderCommand {
    private final DefaultOrderDto defaultOrderDto;
    public DefaultOrderCommand(OrderApi<RealSiteClient, Integer> orderApi, RealSiteOrderDto realSiteOrderDto) {
        super(orderApi, realSiteOrderDto);
        this.defaultOrderDto = toRealSiteOrderDto(realSiteOrderDto);
    }

    private DefaultOrderDto toRealSiteOrderDto(RealSiteOrderDto realSiteOrderDto){
        //TODO need to implement
        return null;
    }
    @Override
    public Order execute(Consumer consumer) throws NotEnoughApiAmountException {
        //TODO need to implement
        OrderedInfo order = orderApi.order((realSiteClient -> realSiteClient.orderDefault(defaultOrderDto)));
        return toOrder(order);
    }
}
