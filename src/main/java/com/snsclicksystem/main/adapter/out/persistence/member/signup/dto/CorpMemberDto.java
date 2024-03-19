package com.snsclicksystem.main.adapter.out.persistence.member.signup.dto;

import com.snsclicksystem.main.domain.member.enums.MemberType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CorpMemberDto extends BaseMemberDto{
	
	public CorpMemberDto(String loginId, String password, String email, MemberType memberType) {
		super(loginId, password, email, memberType);
	}

	private Long corpNum;

}
