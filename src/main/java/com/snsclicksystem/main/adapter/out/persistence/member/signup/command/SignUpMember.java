package com.snsclicksystem.main.adapter.out.persistence.member.signup.command;

import com.snsclicksystem.main.adapter.out.persistence.member.signup.dto.BaseMemberDto;
import com.snsclicksystem.main.application.port.out.persistence.member.MemberRepository;
import com.snsclicksystem.main.domain.member.SignUp;
import com.snsclicksystem.main.domain.member.exception.DuplicateMemberEmailException;
import com.snsclicksystem.main.domain.member.exception.DuplicateMemberLoginIdException;

public abstract class SignUpMember extends SignUp{

	protected final BaseMemberDto baseMemberDto;
	protected final MemberRepository memberRepository;
	
	public SignUpMember(BaseMemberDto baseMemberDto, MemberRepository memberRepository) {
		super();
		this.baseMemberDto = baseMemberDto;
		this.memberRepository = memberRepository;
	}
	
	@Override
	protected void isDuplicateEmail() throws DuplicateMemberEmailException {
		if(memberRepository.existsByEmail(baseMemberDto.getEmail())) {
			throw new DuplicateMemberEmailException();
		}
		
	}

	@Override
	protected void isDuplicateLoginId() throws DuplicateMemberLoginIdException {
		if(memberRepository.existsByLoginId(baseMemberDto.getLoginId())) {
			throw new DuplicateMemberLoginIdException();
		}
	}

}
