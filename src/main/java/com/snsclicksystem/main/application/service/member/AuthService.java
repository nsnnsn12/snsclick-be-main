package com.snsclicksystem.main.application.service.member;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.snsclicksystem.main.application.port.in.member.AuthUseCase;
import com.snsclicksystem.main.application.port.out.persistence.member.MemberRepository;
import com.snsclicksystem.main.auth.JwtAuthentication;
import com.snsclicksystem.main.auth.dto.ResponseToken;
import com.snsclicksystem.main.domain.member.exception.MemberNotFoundException;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class AuthService implements AuthUseCase{
	
	private final MemberRepository memberRepository;
	private final JwtAuthentication jwtAuthentication;
    
	@Override
	public ResponseToken signIn(String username, String password) throws MemberNotFoundException {
		if(!memberRepository.existsByUsername(username)) {
			throw new MemberNotFoundException();
		}
		
		return jwtAuthentication.execute(username, password);
	}
}
