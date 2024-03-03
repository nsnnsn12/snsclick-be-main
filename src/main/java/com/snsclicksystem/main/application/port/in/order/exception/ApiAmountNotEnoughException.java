package com.snsclicksystem.main.application.port.in.order.exception;

public class ApiAmountNotEnoughException extends CreateOrderFailException{
	private static final String message = "api 금액 부족";
	
	
	   public ApiAmountNotEnoughException() {
	        super(message);
	    }

	   public ApiAmountNotEnoughException(String message) {
	        super(message);
	    }

	
	    public ApiAmountNotEnoughException(String message, Throwable cause) {
	        super(message, cause);
	    }

	 
	    public ApiAmountNotEnoughException(Throwable cause) {
	        super(cause);
	    }

	    protected ApiAmountNotEnoughException(String message, Throwable cause,
	                               boolean enableSuppression,
	                               boolean writableStackTrace) {
	        super(message, cause, enableSuppression, writableStackTrace);
	    }
}
