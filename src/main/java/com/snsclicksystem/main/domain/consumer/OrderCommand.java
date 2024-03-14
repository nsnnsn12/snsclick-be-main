package com.snsclicksystem.main.domain.consumer;

import com.snsclicksystem.main.domain.consumer.exception.NotEnoughApiAmountException;
import com.snsclicksystem.main.domain.order.Order;

public interface OrderCommand {
    Order execute(Consumer consumer) throws NotEnoughApiAmountException;
}
