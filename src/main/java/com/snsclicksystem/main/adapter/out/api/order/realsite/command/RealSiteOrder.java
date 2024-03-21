package com.snsclicksystem.main.adapter.out.api.order.realsite.command;

import com.snsclicksystem.main.adapter.out.api.order.realsite.RealSiteClient;
import com.snsclicksystem.main.application.service.order.InternalParameterForOrder;
import com.snsclicksystem.main.domain.order.Order;

/**
 * Real site에 주문 요청을 하는 command
 * Real site에만 해당하는 실행 전후의 공통처리를 맡는다.
 */
public abstract class RealSiteOrder extends Order {
    protected final RealSiteClient realSiteClient;
    public RealSiteOrder(InternalParameterForOrder parameter, RealSiteClient realSiteClient) {
        super(parameter);
        this.realSiteClient = realSiteClient;
    }
}
