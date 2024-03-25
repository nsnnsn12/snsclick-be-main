package com.snsclicksystem.main.domain.member.exception;

public class MemberNotFoundException extends Exception {
	 private static final String DEFAULT_MESSAGE = "해당 회원이 존재하지 않습니다.";


	    public MemberNotFoundException() {
	        super(DEFAULT_MESSAGE);
	    }

}
