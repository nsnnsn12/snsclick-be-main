package com.snsclicksystem.main.domain.member.dto;

import com.snsclicksystem.main.application.service.member.InternalParameterForMember;
import com.snsclicksystem.main.domain.member.SignUp;
import com.snsclicksystem.main.domain.member.enums.MemberSex;
import com.snsclicksystem.main.domain.member.enums.MemberType;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
public class MemberInfo {

	private String loginId;
	
	private String password;
	
	private String email;
	
	private MemberType memberType;
	
	private MemberSex memberSex;
	
	private Long totAmount;
	
	private Long corpNum;
}
