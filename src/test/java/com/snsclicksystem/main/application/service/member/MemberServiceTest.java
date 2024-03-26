package com.snsclicksystem.main.application.service.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import com.snsclicksystem.main.domain.member.Member;
import com.snsclicksystem.main.domain.member.dto.MemberInfo;
import com.snsclicksystem.main.domain.member.exception.DuplicateMemberInfoException;

import static org.assertj.core.api.Assertions.*;

@Transactional
@SpringBootTest
public class MemberServiceTest {
	
	@Autowired
	MemberService memberService;
	
	@Autowired
	PasswordEncoder encoder;
	
	@Test
	void createMember() throws DuplicateMemberInfoException {
		MemberInfo memberInfo = MemberInfo.builder()
										  .username("aa")
										  .password("aa")
										  .email("@@")
										  .build();
		
		Member member = memberService.createMember(memberInfo);
		
		assertThat(member.getUsername()).isEqualTo(memberInfo.getUsername());
		assertThat(encoder.matches(memberInfo.getPassword(), member.getPassword())).isTrue();
	}
	
	@Test
	void duplicateEmail() throws DuplicateMemberInfoException{
		MemberInfo memberInfo1 = MemberInfo.builder()
				  .username("aa")
				  .password("aa")
				  .email("@@")
				  .build();

		memberService.createMember(memberInfo1);		
		
		MemberInfo memberInfo2 = MemberInfo.builder()
				  .username("aaaa")
				  .password("aaaa")
				  .email("@@")
				  .build();		
		
		 Assertions.assertThatThrownBy(() -> memberService.createMember(memberInfo2))
         .isInstanceOf(DuplicateMemberInfoException.class);
	}
	
	@Test
	void duplicateUsername() throws DuplicateMemberInfoException{
		MemberInfo memberInfo1 = MemberInfo.builder()
				  .username("aaaa")
				  .password("aa")
				  .email("@@@@")
				  .build();

		memberService.createMember(memberInfo1);		
		
		MemberInfo memberInfo2 = MemberInfo.builder()
				  .username("aaaa")
				  .password("aaaa")
				  .email("@@")
				  .build();		
		
		 Assertions.assertThatThrownBy(() -> memberService.createMember(memberInfo2))
         .isInstanceOf(DuplicateMemberInfoException.class);
	}

}
