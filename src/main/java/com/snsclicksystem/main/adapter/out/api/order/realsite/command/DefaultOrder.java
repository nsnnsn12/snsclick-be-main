package com.snsclicksystem.main.adapter.out.api.order.realsite.command;

import com.snsclicksystem.main.domain.order.dto.OrderedInfo;
import com.snsclicksystem.main.adapter.out.api.order.realsite.RealSiteClient;
import com.snsclicksystem.main.adapter.out.api.order.realsite.dto.DefaultOrderDto;
import com.snsclicksystem.main.application.service.order.InternalParameterForOrder;

/**
 * 오직 default order를 실행하기 위한 책임만을 가진다.
 */
public class DefaultOrder extends RealSiteOrder {
    private final DefaultOrderDto defaultOrderDto;
    public DefaultOrder(RealSiteClient realSiteClient, InternalParameterForOrder parameter, DefaultOrderDto defaultOrderDto) {
        super(parameter, realSiteClient);
        this.defaultOrderDto = defaultOrderDto;
    }

    /**
     * default order 실행
     * @return 주문 후 생성된 결과
     */
    @Override
    protected OrderedInfo order() {
        Integer orderId = realSiteClient.orderDefault(defaultOrderDto);
        return getOrderedInfo(orderId);
    }
}
