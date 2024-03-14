package com.snsclicksystem.main.domain.consumer;

import com.snsclicksystem.main.domain.consumer.exception.NotEnoughApiAmountException;
import com.snsclicksystem.main.domain.consumer.exception.NotEnoughConsumerAmountException;
import com.snsclicksystem.main.domain.item.SnsItem;
import com.snsclicksystem.main.domain.order.Order;
import lombok.Getter;

@Getter
public class Consumer {
    private Long consumerId;
    private String consumerName;
    private Integer amount;
    private SnsItem snsItem;

    public Order order(OrderCommand orderCommand) throws NotEnoughConsumerAmountException, NotEnoughApiAmountException {
        //TODO 해외 api에 주문하는 것 외에 우리 자체에서 필요한 비즈니스 로직이 있다면 처리 필요
        //ex) 사용자 잔액 확인 등
        if(this.amount < snsItem.getItemPrice()) {
            throw new NotEnoughConsumerAmountException();
        }
        return orderCommand.execute(this);
    }
}
