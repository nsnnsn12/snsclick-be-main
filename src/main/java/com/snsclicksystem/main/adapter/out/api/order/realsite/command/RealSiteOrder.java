package com.snsclicksystem.main.adapter.out.api.order.realsite.command;

import com.snsclicksystem.main.domain.order.dto.OrderedInfo;
import com.snsclicksystem.main.adapter.out.api.order.realsite.RealSiteClient;
import com.snsclicksystem.main.application.service.order.InternalParameterForOrder;
import com.snsclicksystem.main.domain.order.Order;

/**
 * Real site에 주문 요청을 하는 command
 * 주문 실행 전후의 공통처리를 맡는다.
 */
public abstract class RealSiteOrder extends Order {
    protected final RealSiteClient realSiteClient;
    public RealSiteOrder(InternalParameterForOrder parameter, RealSiteClient realSiteClient) {
        super(parameter);
        this.realSiteClient = realSiteClient;
    }

    /**
     * 만약 각 주문마다 OrderedInfo를 생성하는 로직이 같다면 해당 메서드는 추상 클래스로 빼서 공통 처리할 예정
     */
    protected OrderedInfo getOrderedInfo(Integer orderId){
        //TODO need to implement
        return new OrderedInfo();
    }
}
