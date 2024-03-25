package com.snsclicksystem.main.application.port.in.member;

import com.snsclicksystem.main.domain.member.Member;
import com.snsclicksystem.main.domain.member.dto.MemberInfo;
import com.snsclicksystem.main.domain.member.exception.DuplicateMemberInfoException;

public interface MemberUseCase {

	Member createMember(MemberInfo memberInfo) throws DuplicateMemberInfoException;

}
