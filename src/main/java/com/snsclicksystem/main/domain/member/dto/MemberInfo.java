package com.snsclicksystem.main.domain.member.dto;

import com.snsclicksystem.main.domain.member.enums.MemberType;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder

/*
 * 회원가입 시, 회원 가입 정보가 들어오는 DTO
 */
public class MemberInfo {

	private String loginId;
	
	private String password;
	
	private String email;
}
