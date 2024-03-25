package com.snsclicksystem.main.auth;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.snsclicksystem.main.application.port.out.persistence.member.MemberRepository;
import com.snsclicksystem.main.domain.member.Member;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomUserDetailsService implements UserDetailsService{
	
	private final MemberRepository memberRepository;
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return memberRepository.findByUsername(username)
				.map(this::createUserDetails)
				.orElseThrow(() ->new UsernameNotFoundException(username + "을 DB에서 찾을 수 없음"));
	}
	
	private UserDetails createUserDetails(Member member) {
		return User.builder()
				.username(member.getUsername())
				.password(member.getPassword())
				.roles(member.getMemberType().toString())
				.build();
	}

}
