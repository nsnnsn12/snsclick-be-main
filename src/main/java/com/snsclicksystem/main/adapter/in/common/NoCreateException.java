package com.snsclicksystem.main.adapter.in.common;

public class NoCreateException extends RuntimeException {

	public NoCreateException() {
		super();
	}
	public NoCreateException(String message) {
		super(message);
	}
	public NoCreateException(String message, Throwable cause) {
		super(message, cause);
	}

	public NoCreateException(Throwable cause) {
		super(cause);
	}

	protected NoCreateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
