package com.snsclicksystem.main.adapter.in.member.factory;

import com.snsclicksystem.main.adapter.in.member.dto.RequestSignUp;
import com.snsclicksystem.main.adapter.out.persistence.member.signup.command.CorpMember;
import com.snsclicksystem.main.adapter.out.persistence.member.signup.command.NormalMember;
import com.snsclicksystem.main.adapter.out.persistence.member.signup.dto.BaseMemberDto;
import com.snsclicksystem.main.adapter.out.persistence.member.signup.dto.CorpMemberDto;
import com.snsclicksystem.main.adapter.out.persistence.member.signup.dto.NormalMemberDto;
import com.snsclicksystem.main.application.port.out.persistence.member.MemberRepository;
import com.snsclicksystem.main.application.service.member.InternalParameterForMember;
import com.snsclicksystem.main.application.service.member.MemberFactory;
import com.snsclicksystem.main.domain.member.SignUp;
import com.snsclicksystem.main.domain.member.enums.MemberType;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class SignUpFactory implements MemberFactory{
	
	private final RequestSignUp request;

	@Override
	public SignUp getMember(InternalParameterForMember parameter) {
		String password = parameter.getEncoder().encode(request.getPassword());
		
		BaseMemberDto baseMemberDto = BaseMemberDto
										.builder()
										.email(request.getEmail())
										.loginId(request.getLoginId())
										.password(password)
										.memberType(request.getMemberType())
										.build();
		
		MemberType memberType = baseMemberDto.getMemberType();
		switch(memberType) {
		case NORMAL:
			return getNormalMember(baseMemberDto, parameter);
		case CORP:
			return getCorpMember(baseMemberDto, parameter);
		default:
			//TODO : Exception customizing
			throw new IllegalArgumentException("회원 타입이 잘못되었습니다.");
		}
	}
	
	private SignUp getCorpMember(BaseMemberDto baseMemberDto, InternalParameterForMember parameter) {
		CorpMemberDto corpMemberDto = (CorpMemberDto) baseMemberDto;
		corpMemberDto.setCorpNum(request.getCorpNum());
		return new CorpMember(corpMemberDto, parameter.getMemberRepository());
	}

	private SignUp getNormalMember(BaseMemberDto baseMemberDto, InternalParameterForMember parameter) {
		NormalMemberDto normalMemberDto = (NormalMemberDto) baseMemberDto;
		normalMemberDto.setSex(request.getMemberSex());
		return new NormalMember(normalMemberDto, parameter.getMemberRepository());
	}

}
