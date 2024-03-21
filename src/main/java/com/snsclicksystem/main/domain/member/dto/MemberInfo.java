package com.snsclicksystem.main.domain.member.dto;

import com.snsclicksystem.main.domain.member.enums.MemberType;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MemberInfo {

	private String loginId;
	
	private String password;
	
	private String email;

	private MemberType memberType;
	
	
	private Long totalAmount;
}
