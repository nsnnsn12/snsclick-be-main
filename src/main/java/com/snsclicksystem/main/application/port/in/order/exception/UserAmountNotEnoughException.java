package com.snsclicksystem.main.application.port.in.order.exception;

public class UserAmountNotEnoughException extends CreateOrderFailException{
	private static final String message = "사용자 금액 부족";
	
	   public UserAmountNotEnoughException() {
	        super(message);
	    }

	   public UserAmountNotEnoughException(String message) {
	        super(message);
	    }

	
	    public UserAmountNotEnoughException(String message, Throwable cause) {
	        super(message, cause);
	    }

	 
	    public UserAmountNotEnoughException(Throwable cause) {
	        super(cause);
	    }

	    protected UserAmountNotEnoughException(String message, Throwable cause,
	                               boolean enableSuppression,
	                               boolean writableStackTrace) {
	        super(message, cause, enableSuppression, writableStackTrace);
	    }
}
