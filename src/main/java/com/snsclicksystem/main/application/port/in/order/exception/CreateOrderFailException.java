package com.snsclicksystem.main.application.port.in.order.exception;

public class CreateOrderFailException extends Exception{
	
	private static final String message = "주문 실패";
	
	
	   public CreateOrderFailException() {
	        super(message);
	    }

	   public CreateOrderFailException(String message) {
	        super(message);
	    }

	
	    public CreateOrderFailException(String message, Throwable cause) {
	        super(message, cause);
	    }

	 
	    public CreateOrderFailException(Throwable cause) {
	        super(cause);
	    }

	    protected CreateOrderFailException(String message, Throwable cause,
	                               boolean enableSuppression,
	                               boolean writableStackTrace) {
	        super(message, cause, enableSuppression, writableStackTrace);
	    }

}
