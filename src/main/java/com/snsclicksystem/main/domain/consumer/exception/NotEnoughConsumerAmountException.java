package com.snsclicksystem.main.domain.consumer.exception;

import com.snsclicksystem.main.application.port.in.order.exception.CreateOrderFailException;

public class NotEnoughConsumerAmountException extends CreateOrderFailException {
    private static final String message = "사용자 금액 부족";

    public NotEnoughConsumerAmountException() {
        super(message);
    }

    public NotEnoughConsumerAmountException(String message) {
        super(message);
    }


    public NotEnoughConsumerAmountException(String message, Throwable cause) {
        super(message, cause);
    }


    public NotEnoughConsumerAmountException(Throwable cause) {
        super(cause);
    }

    protected NotEnoughConsumerAmountException(String message, Throwable cause,
                                               boolean enableSuppression,
                                               boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
