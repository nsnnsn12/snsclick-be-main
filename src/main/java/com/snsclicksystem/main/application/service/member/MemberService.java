package com.snsclicksystem.main.application.service.member;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.snsclicksystem.main.application.port.in.member.MemberUseCase;
import com.snsclicksystem.main.application.port.out.persistence.member.MemberRepository;
import com.snsclicksystem.main.domain.member.Member;
import com.snsclicksystem.main.domain.member.SignUp;
import com.snsclicksystem.main.domain.member.exception.DuplicateMemberEmailException;
import com.snsclicksystem.main.domain.member.exception.DuplicateMemberLoginIdException;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class MemberService implements MemberUseCase{
	
	private final MemberRepository memberRepository;
	private final PasswordEncoder encoder;
	
	@Override
	public Member createMember(MemberFactory memberCommandFactory) throws DuplicateMemberEmailException, DuplicateMemberLoginIdException {
		SignUp signUp = memberCommandFactory.getMember(InternalParameterForMember.builder().encoder(encoder).memberRepository(memberRepository).build());
		
		//TODO : Exception customizing
		return memberRepository.save(signUp.execute());
	}
	
}
