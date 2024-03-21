package com.snsclicksystem.main.application.service.member;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.snsclicksystem.main.adapter.in.member.dto.RequestSignUp;
import com.snsclicksystem.main.application.port.in.member.MemberUseCase;
import com.snsclicksystem.main.application.port.out.persistence.member.MemberRepository;
import com.snsclicksystem.main.domain.member.Member;
import com.snsclicksystem.main.domain.member.dto.MemberInfo;
import com.snsclicksystem.main.domain.member.enums.MemberType;
import com.snsclicksystem.main.domain.member.exception.DuplicateMemberEmailException;
import com.snsclicksystem.main.domain.member.exception.DuplicateMemberLoginIdException;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class MemberService implements MemberUseCase {
	
	private final MemberRepository memberRepository;
	private final PasswordEncoder encoder;

	@Override
	public Member createMember(RequestSignUp request) throws DuplicateMemberEmailException, DuplicateMemberLoginIdException {
		isDuplicateEmail(request.getEmail());
		isDuplicateLoginId(request.getLoginId());
		
		MemberInfo memberInfo = getMemberInfo(request);
		
		return memberRepository.save(memberInfo);
	}
	
	private MemberInfo getMemberInfo(RequestSignUp request) {
		String password = encoder.encode(request.getPassword());
		
		return MemberInfo.builder()
						 .loginId(request.getLoginId())
						 .password(password)
						 .totalAmount(0L)
						 .memberType(MemberType.NORMAL)
						 .email(request.getEmail())
						 .build();
	}

	private void isDuplicateEmail(String email) throws DuplicateMemberEmailException {
		if(memberRepository.existsByEmail(email)) {
			throw new DuplicateMemberEmailException();
		}
		
	}

	private void isDuplicateLoginId(String loginId) throws DuplicateMemberLoginIdException {
		if(memberRepository.existsByLoginId(loginId)) {
			throw new DuplicateMemberLoginIdException();
		}
	}

}
