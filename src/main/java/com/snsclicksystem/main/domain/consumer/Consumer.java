package com.snsclicksystem.main.domain.consumer;

import com.snsclicksystem.main.application.port.in.order.exception.UserAmountNotEnoughException;
import com.snsclicksystem.main.domain.item.SnsItem;
import com.snsclicksystem.main.domain.order.Order;
import lombok.Getter;

@Getter
public class Consumer {
    private Long consumerId;
    private String consumerName;
    private Integer amount;

    public Order order(SnsItem item) throws UserAmountNotEnoughException {
        if(amount < item.getItemPrice()) {
            throw new UserAmountNotEnoughException();
        }
        return Order.builder().item(item).consumerId(consumerId).build();
    }
}
