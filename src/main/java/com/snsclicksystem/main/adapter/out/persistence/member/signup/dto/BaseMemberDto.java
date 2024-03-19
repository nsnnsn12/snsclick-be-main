package com.snsclicksystem.main.adapter.out.persistence.member.signup.dto;

import com.snsclicksystem.main.domain.member.enums.MemberType;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class BaseMemberDto {
	
	private String loginId;
	
	private String password;
	
	private String email;
	
	private MemberType memberType;

}
