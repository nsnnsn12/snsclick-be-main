package com.snsclicksystem.main.application.service.member;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.snsclicksystem.main.application.port.in.member.MemberUseCase;
import com.snsclicksystem.main.application.port.out.persistence.member.MemberRepository;
import com.snsclicksystem.main.domain.member.Member;
import com.snsclicksystem.main.domain.member.dto.MemberInfo;
import com.snsclicksystem.main.domain.member.enums.MemberType;
import com.snsclicksystem.main.domain.member.exception.DuplicateMemberInfoException;
import com.snsclicksystem.main.domain.member.exception.MemberExceptionMessage;

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
	public Member createMember(MemberInfo memberInfo) throws DuplicateMemberInfoException {
		isDuplicateEmail(memberInfo.getEmail());
		isDuplicateLoginId(memberInfo.getLoginId());
		
		Member member = getMember(memberInfo);
		
		return memberRepository.save(member);
	}
	
	private Member getMember(MemberInfo memberInfo) {
		String password = encoder.encode(memberInfo.getPassword());
		
		return Member.builder()
						 .loginId(memberInfo.getLoginId())
						 .password(password)
						 .totalAmount(0L)
						 .memberType(MemberType.NORMAL)
						 .email(memberInfo.getEmail())
						 .build();
	}

	private void isDuplicateEmail(String email) throws DuplicateMemberInfoException {
		if(memberRepository.existsByEmail(email)) {
			throw new DuplicateMemberInfoException(MemberExceptionMessage.DUPLICATE_MEMBER_EMAIL.getMessage());
		}
		
	}

	private void isDuplicateLoginId(String loginId) throws DuplicateMemberInfoException {
		if(memberRepository.existsByLoginId(loginId)) {
			throw new DuplicateMemberInfoException(MemberExceptionMessage.DUPLICATE_MEMBER_LOGIN_ID.getMessage());
		}
	}

}
