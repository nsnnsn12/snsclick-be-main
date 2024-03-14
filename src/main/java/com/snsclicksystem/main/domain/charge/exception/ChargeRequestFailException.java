package com.snsclicksystem.main.domain.charge.exception;

public class ChargeRequestFailException extends Exception {

    private static final String DEFAULT_MESSAGE = "충전요청 실패";


    public ChargeRequestFailException() {
        super(DEFAULT_MESSAGE);
    }

    public ChargeRequestFailException(String message) {
        super(message);
    }


    public ChargeRequestFailException(String message, Throwable cause) {
        super(message, cause);
    }


    public ChargeRequestFailException(Throwable cause) {
        super(cause);
    }

    protected ChargeRequestFailException(String message, Throwable cause,
                                       boolean enableSuppression,
                                       boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
