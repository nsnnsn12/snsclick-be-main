package com.snsclicksystem.main.domain.member.exception;

public class DuplicateMemberLoginIdException extends Exception{
	 private static final String DEFAULT_MESSAGE = "이미 사용중인 아이디 입니다.";

	    public DuplicateMemberLoginIdException() {
	        super(DEFAULT_MESSAGE);
	    }
}
