package com.snsclicksystem.main.adapter.out.persistence.member.signup.command;

import com.snsclicksystem.main.adapter.out.persistence.member.signup.dto.CorpMemberDto;
import com.snsclicksystem.main.application.port.out.persistence.member.MemberRepository;
import com.snsclicksystem.main.domain.member.dto.MemberInfo;

public class CorpMember extends SignUpMember{
	
	private CorpMemberDto corpMemberDto;

	public CorpMember(CorpMemberDto corpMemberDto, MemberRepository memberRepository) {
		super(corpMemberDto, memberRepository);
		this.corpMemberDto = corpMemberDto;
	}

	@Override
	protected MemberInfo signUp() {
		return getMemberInfo();
	}
	
	private MemberInfo getMemberInfo() {
		return MemberInfo.builder()
					.loginId(this.corpMemberDto.getLoginId())
					.password(this.corpMemberDto.getPassword())
					.email(this.corpMemberDto.getEmail())
					.memberType(this.corpMemberDto.getMemberType())
					.corpNum(this.corpMemberDto.getCorpNum())
					.totAmount(0L)
					.build();
	}
}
