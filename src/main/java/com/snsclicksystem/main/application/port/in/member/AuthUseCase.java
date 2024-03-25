package com.snsclicksystem.main.application.port.in.member;

import com.snsclicksystem.main.auth.dto.ResponseToken;
import com.snsclicksystem.main.domain.member.exception.MemberNotFoundException;

public interface AuthUseCase {
	
	public ResponseToken signIn(String loninId, String password) throws MemberNotFoundException;


}
