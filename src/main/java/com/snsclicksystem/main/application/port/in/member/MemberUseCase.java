package com.snsclicksystem.main.application.port.in.member;

import com.snsclicksystem.main.application.service.member.MemberFactory;
import com.snsclicksystem.main.domain.member.Member;
import com.snsclicksystem.main.domain.member.SignUp;
import com.snsclicksystem.main.domain.member.exception.DuplicateMemberEmailException;
import com.snsclicksystem.main.domain.member.exception.DuplicateMemberLoginIdException;

public interface MemberUseCase {

	public Member createMember(MemberFactory memberCommandFactory) throws DuplicateMemberEmailException, DuplicateMemberLoginIdException;

}
