package com.snsclicksystem.main.domain.member;

import com.snsclicksystem.main.domain.member.dto.MemberInfo;
import com.snsclicksystem.main.domain.member.exception.DuplicateMemberEmailException;
import com.snsclicksystem.main.domain.member.exception.DuplicateMemberLoginIdException;

public abstract class SignUp {
	
	public SignUp() {
	}
	
    /**
     * 회원가입 처리
     * @return 고객 정보
     * @throws DuplicateMemberLoginIdException 
     * @throws DuplicateMemberEmailException 
     */
	public final MemberInfo execute() throws DuplicateMemberEmailException, DuplicateMemberLoginIdException {
		
		canSignUp();
		
		return signUp();
	}
	
	private void canSignUp() throws DuplicateMemberEmailException, DuplicateMemberLoginIdException {
		isDuplicateEmail();
		isDuplicateLoginId();
	}

	protected abstract void isDuplicateEmail() throws DuplicateMemberEmailException;

	protected abstract void isDuplicateLoginId() throws DuplicateMemberLoginIdException;

	 protected abstract MemberInfo signUp();



}
