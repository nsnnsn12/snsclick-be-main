package com.snsclicksystem.main.domain.member;


import com.snsclicksystem.main.domain.member.enums.MemberType;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Member {
	
	private String loginId;
	
	private String email;
	
	private String password;
	
	private MemberType memberType;

	
}
