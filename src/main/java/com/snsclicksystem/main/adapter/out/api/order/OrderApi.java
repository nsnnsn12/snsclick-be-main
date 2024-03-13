package com.snsclicksystem.main.adapter.out.api.order;

import com.snsclicksystem.main.adapter.out.api.order.dto.OrderedInfo;
import com.snsclicksystem.main.domain.consumer.exception.NotEnoughApiAmountException;

import java.util.function.Function;

public interface OrderApi<T, R> {
	OrderedInfo order(Function<T, R> order) throws NotEnoughApiAmountException;
}

