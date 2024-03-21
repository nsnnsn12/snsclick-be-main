package com.snsclicksystem.main.application.port.in.member;

import com.snsclicksystem.main.application.service.member.MemberFactory;
import com.snsclicksystem.main.auth.dto.ResponseToken;
import com.snsclicksystem.main.domain.member.Member;
import com.snsclicksystem.main.domain.member.exception.DuplicateMemberEmailException;
import com.snsclicksystem.main.domain.member.exception.DuplicateMemberLoginIdException;
import com.snsclicksystem.main.domain.member.exception.MemberNotFoundException;

public interface AuthUseCase {
	
	public ResponseToken signIn(String loninId, String password) throws MemberNotFoundException;

	public Member createMember(MemberFactory memberCommandFactory) throws DuplicateMemberEmailException, DuplicateMemberLoginIdException;

}
