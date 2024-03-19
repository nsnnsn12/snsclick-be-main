package com.snsclicksystem.main.application.service.member;

import com.snsclicksystem.main.domain.member.SignUp;

public interface MemberFactory {


	public SignUp getMember(InternalParameterForMember parameter);

}
