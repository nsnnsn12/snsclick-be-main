package com.snsclicksystem.main.domain.member.exception;

public enum MemberExceptionMessage {
	
	DUPLICATE_MEMBER_EMAIL("이미 사용중인 이메일 입니다."),
	DUPLICATE_MEMBER_LOGIN_ID("이미 사용중인 로그인ID 입니다.");

	private String message;
	
	MemberExceptionMessage(String message){
		this.message = message;
	}
	
	 public String getMessage() {
		 return message;
	 }
	
	
	
}
