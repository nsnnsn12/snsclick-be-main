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
		//TODO: username, password, email validation rule definition
		isDuplicateEmail(memberInfo.getEmail());
		isDuplicateUsername(memberInfo.getUsername());
		
		Member member = getMember(memberInfo);
		
		return memberRepository.save(member);
	}
	
	private Member getMember(MemberInfo memberInfo) {
		String password = encoder.encode(memberInfo.getPassword());
		
		return Member.builder()
						 .username(memberInfo.getUsername())
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

	private void isDuplicateUsername(String username) throws DuplicateMemberInfoException {
		if(memberRepository.existsByUsername(username)) {
			throw new DuplicateMemberInfoException(MemberExceptionMessage.DUPLICATE_MEMBER_USERNAME.getMessage());
		}
	}

}
