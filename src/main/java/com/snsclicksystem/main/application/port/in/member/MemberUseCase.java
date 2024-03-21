package com.snsclicksystem.main.application.port.in.member;

import com.snsclicksystem.main.adapter.in.member.dto.RequestSignUp;
import com.snsclicksystem.main.domain.member.Member;
import com.snsclicksystem.main.domain.member.exception.DuplicateMemberEmailException;
import com.snsclicksystem.main.domain.member.exception.DuplicateMemberLoginIdException;

public interface MemberUseCase {

	Member createMember(RequestSignUp request) throws DuplicateMemberEmailException, DuplicateMemberLoginIdException;

}
