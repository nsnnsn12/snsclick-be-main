package com.snsclicksystem.main.domain.member.exception;

public class DuplicateMemberEmailException extends Exception{
	 private static final String DEFAULT_MESSAGE = "이미 사용중인 이메일 입니다.";


	    public DuplicateMemberEmailException() {
	        super(DEFAULT_MESSAGE);
	    }

}
