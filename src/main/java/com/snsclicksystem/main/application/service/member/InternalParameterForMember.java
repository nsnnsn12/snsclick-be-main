package com.snsclicksystem.main.application.service.member;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.snsclicksystem.main.application.port.out.persistence.member.MemberRepository;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class InternalParameterForMember {

	private PasswordEncoder encoder;
	
	private MemberRepository memberRepository;
	
}
