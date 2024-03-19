package com.snsclicksystem.main.adapter.out.persistence.member.signup.command;

import com.snsclicksystem.main.adapter.out.persistence.member.signup.dto.NormalMemberDto;
import com.snsclicksystem.main.application.port.out.persistence.member.MemberRepository;
import com.snsclicksystem.main.domain.member.dto.MemberInfo;

public class NormalMember extends SignUpMember{
	
	private final NormalMemberDto normalMemberDto;

	public NormalMember(NormalMemberDto normalMemberDto, MemberRepository memberRepository) {
		super(normalMemberDto, memberRepository);
		this.normalMemberDto = normalMemberDto;
	}

	@Override
	protected MemberInfo signUp() {
		return getMemberInfo();
	}

	private MemberInfo getMemberInfo() {
		return MemberInfo.builder()
					.loginId(this.normalMemberDto.getLoginId())
					.password(this.normalMemberDto.getPassword())
					.email(this.normalMemberDto.getEmail())
					.memberType(this.normalMemberDto.getMemberType())
					.memberSex(this.normalMemberDto.getSex())
					.totAmount(0L)
					.build();
	}

}
