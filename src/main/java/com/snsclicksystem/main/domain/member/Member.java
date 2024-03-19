package com.snsclicksystem.main.domain.member;

import com.snsclicksystem.main.application.service.member.InternalParameterForMember;
import com.snsclicksystem.main.domain.member.dto.MemberInfo;
import com.snsclicksystem.main.domain.order.exception.NotEnoughApiAmountException;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Builder
public class Member {
	
	private String email;
	


	
}
