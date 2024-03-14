package com.snsclicksystem.main.adapter.out.api.order.realsite.command;

import com.snsclicksystem.main.adapter.out.api.order.dto.OrderedInfo;
import com.snsclicksystem.main.adapter.out.api.order.realsite.RealSiteClient;
import com.snsclicksystem.main.adapter.out.api.order.realsite.dto.DefaultOrderDto;

/**
 * 오직 default order를 실행하기 위한 책임만을 가진다.
 */
public class DefaultOrderCommand extends RealSiteOrderCommand {
    private final DefaultOrderDto defaultOrderDto;
    public DefaultOrderCommand(RealSiteClient realSiteClient, DefaultOrderDto defaultOrderDto) {
        super(realSiteClient);
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

    /**
     * 만약 각 주문마다 OrderedInfo를 생성하는 로직이 같다면 해당 메서드는 추상 클래스로 빼서 공통 처리할 예정
     */
    private OrderedInfo getOrderedInfo(Integer orderId){
        //TODO need to implement
        return new OrderedInfo();
    }
}
