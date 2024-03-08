package com.snsclicksystem.main.application.port.out.api.order.exception;

import com.snsclicksystem.main.application.port.in.order.exception.CreateOrderFailException;

public class NotEnoughApiAmountException extends CreateOrderFailException {
    private static final String message = "api 금액 부족";


    public NotEnoughApiAmountException() {
        super(message);
    }

    public NotEnoughApiAmountException(String message) {
        super(message);
    }


    public NotEnoughApiAmountException(String message, Throwable cause) {
        super(message, cause);
    }


    public NotEnoughApiAmountException(Throwable cause) {
        super(cause);
    }

    protected NotEnoughApiAmountException(String message, Throwable cause,
                                          boolean enableSuppression,
                                          boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
