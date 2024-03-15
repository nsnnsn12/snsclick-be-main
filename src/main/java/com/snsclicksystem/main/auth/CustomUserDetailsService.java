package com.snsclicksystem.main.auth;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.snsclicksystem.main.adapter.out.persistence.member.MemberEntity;
import com.snsclicksystem.main.application.port.out.persistence.member.MemberRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomUserDetailsService implements UserDetailsService{
	
	private final MemberRepository memberRepository;
	
	//TODO : 회원가입 시 암호화해서 비밀번호 저장 (해당 기능 구현 시 Delete)
	private final PasswordEncoder passwordEncoder;
	
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return memberRepository.findEntityByLoginId(username)
				.map(this::createUserDetails)
				.orElseThrow(() ->new UsernameNotFoundException(username + "을 DB에서 찾을 수 없음"));
	}
	
	private UserDetails createUserDetails(MemberEntity member) {
		return User.builder()
				.username(member.getLoginId())
				//TODO : 회원가입 시 암호화해서 비밀번호 저장 (해당 기능 구현 시 encode 함수 제거)
				.password(passwordEncoder.encode(member.getPassword()))
				.roles(member.getMemberType().toString())
				.build();
	}

}
