package com.snsclicksystem.main.domain.consumer;

import com.snsclicksystem.main.domain.consumer.exception.NotEnoughConsumerAmountException;
import com.snsclicksystem.main.domain.item.SnsItem;
import com.snsclicksystem.main.domain.order.Order;
import lombok.Getter;

@Getter
public class Consumer {
    private Long consumerId;
    private String consumerName;
    private Integer amount;

    public Order order(SnsItem item) throws NotEnoughConsumerAmountException {
        if(amount < item.getItemPrice()) {
            throw new NotEnoughConsumerAmountException();
        }
        return Order.builder().item(item).consumerId(consumerId).build();
    }
}
