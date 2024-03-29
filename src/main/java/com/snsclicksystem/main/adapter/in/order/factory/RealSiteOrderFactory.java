package com.snsclicksystem.main.adapter.in.order.factory;

import com.snsclicksystem.main.adapter.in.order.dto.RequestOrder;
import com.snsclicksystem.main.adapter.out.api.order.realsite.RealSiteClient;
import com.snsclicksystem.main.adapter.out.api.order.realsite.command.DefaultOrder;
import com.snsclicksystem.main.adapter.out.api.order.realsite.dto.BaseOrderDto;
import com.snsclicksystem.main.adapter.out.api.order.realsite.dto.DefaultOrderDto;
import com.snsclicksystem.main.adapter.out.persistence.real_site.RealSiteEntity;
import com.snsclicksystem.main.adapter.out.persistence.real_site.RealSiteRepository;
import com.snsclicksystem.main.adapter.out.persistence.real_site.RealSiteType;
import com.snsclicksystem.main.application.service.order.InternalParameterForOrder;
import com.snsclicksystem.main.application.service.order.OrderFactory;
import com.snsclicksystem.main.domain.order.Order;
import lombok.RequiredArgsConstructor;

/**
 * 사용자의 요청을 받아 Real site에 맞는 주문을 생성하는 팩토리
 */
@RequiredArgsConstructor
public class RealSiteOrderFactory implements OrderFactory {
    private final RequestOrder order;
    protected final RealSiteClient realSiteClient;
    private final String apiKey;
    private final RealSiteRepository realSiteRepository;
    private static final String ADD = "add";
    @Override
    public Order getOrder(InternalParameterForOrder parameter) {
        RealSiteEntity realSiteEntity = realSiteRepository.findByItemId(order.getItemId());
        RealSiteType realSiteType = realSiteEntity.getRealSiteType();

        BaseOrderDto baseOrderDto = BaseOrderDto.builder().apiKey(apiKey).action(ADD).serviceId(realSiteEntity.getServiceId()).build();
        switch (realSiteType) {
            case DEFAULT:
                return getDefaultOrder(baseOrderDto, parameter);
            default:
                throw new IllegalArgumentException("주문 타입이 잘못되었습니다.");
        }
    }

    private Order getDefaultOrder(BaseOrderDto baseOrderDto, InternalParameterForOrder parameter){
        DefaultOrderDto defaultOrderDto = (DefaultOrderDto) baseOrderDto;
        defaultOrderDto.setLink(order.getLink());
        defaultOrderDto.setQuantity(order.getQuantity());
        defaultOrderDto.setRuns(order.getRuns());
        defaultOrderDto.setInterval(order.getInterval());
        return new DefaultOrder(realSiteClient, parameter, defaultOrderDto);
    }
}
