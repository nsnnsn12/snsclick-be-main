package com.snsclicksystem.main.adapter.out.api.order.realsite.command;

import com.snsclicksystem.main.domain.order.dto.OrderedInfo;
import com.snsclicksystem.main.adapter.out.api.order.realsite.RealSiteClient;
import com.snsclicksystem.main.adapter.out.api.order.realsite.dto.DefaultOrderDto;
import com.snsclicksystem.main.application.service.order.InternalParameterForOrder;
import com.snsclicksystem.main.domain.order.exception.NotEnoughConsumerAmountException;
import com.snsclicksystem.main.domain.transaction_history.TransactionHistory;
import com.snsclicksystem.main.domain.transaction_history.TransactionType;

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
        Long orderedId = realSiteClient.orderDefault(defaultOrderDto);
        return getOrderedInfo(orderedId);
    }

    //TODO 이 부분도 공통화가 공통화가 가능하면 RealSiteOrder로 옮기는 것이 좋을 듯.
    @Override
    protected void isMoneyEnough() throws NotEnoughConsumerAmountException {
        if(parameter.getMember().getTotalAmount() < (long) defaultOrderDto.getQuantity() * parameter.getItem().getPrice()){
            throw new NotEnoughConsumerAmountException();
        }
    }

    //TODO 나중에 RealSiteOrder 내의 공통 타입을 한 번 더 묶어 getOrderedInfo, getTransactionHistory 메서드를 RealSiteOrder로 옮기는 것이 좋을 듯.
    private OrderedInfo getOrderedInfo(Long orderedId){
        return OrderedInfo.builder().item(parameter.getItem())
                .transactionHistory(getTransactionHistory())
                .memberId(parameter.getMember().getId())
                .externalOrderedId(orderedId)
                .targetLink(defaultOrderDto.getLink())
                .orderBeforeQuantity(defaultOrderDto.getOrderBeforeQuantity())
                .completedStatus(false)
                .orderQuantity(defaultOrderDto.getQuantity())
                .build();
    }

    private TransactionHistory getTransactionHistory(){
        return TransactionHistory.builder()
                .transactionType(TransactionType.PAYMENT)
                .memberId(parameter.getMember().getId())
                .amount(defaultOrderDto.getQuantity() * parameter.getItem().getPrice()).build();
    }
}
