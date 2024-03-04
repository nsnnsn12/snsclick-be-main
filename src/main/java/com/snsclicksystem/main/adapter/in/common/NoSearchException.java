package com.snsclicksystem.main.adapter.in.common;

import lombok.Getter;

@Getter
public class NoSearchException extends RuntimeException {
    public NoSearchException() {
        super();
    }
    public NoSearchException(String message) {
        super(message);
    }
    public NoSearchException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoSearchException(Throwable cause) {
        super(cause);
    }

    protected NoSearchException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
