package com.snsclicksystem.main.adapter.out.persistence.member.signup.dto;

import com.snsclicksystem.main.domain.member.enums.MemberSex;
import com.snsclicksystem.main.domain.member.enums.MemberType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NormalMemberDto extends BaseMemberDto{


	public NormalMemberDto(String loginId, String password, String email, MemberType memberType) {
		super(loginId, password, email, memberType);
	}

	private MemberSex sex;

}
