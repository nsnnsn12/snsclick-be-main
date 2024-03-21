package com.snsclicksystem.main.application.service.member;


import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.snsclicksystem.main.application.port.in.member.AuthUseCase;
import com.snsclicksystem.main.application.port.out.persistence.member.MemberRepository;
import com.snsclicksystem.main.auth.dto.ResponseToken;
import com.snsclicksystem.main.auth.jwt.JwtTokenProvider;
import com.snsclicksystem.main.domain.member.Member;
import com.snsclicksystem.main.domain.member.SignUp;
import com.snsclicksystem.main.domain.member.exception.DuplicateMemberEmailException;
import com.snsclicksystem.main.domain.member.exception.DuplicateMemberLoginIdException;
import com.snsclicksystem.main.domain.member.exception.MemberNotFoundException;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class AuthService implements AuthUseCase{
	
	private final MemberRepository memberRepository;
	private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder encoder;

	@Override
	public ResponseToken signIn(String loginId, String password) throws MemberNotFoundException {
		if(!memberRepository.existsByLoginId(loginId)) {
			throw new MemberNotFoundException();
		}
		// 1. username + password 를 기반으로 Authentication 객체 생성
        // 이때 authentication 은 인증 여부를 확인하는 authenticated 값이 false
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginId, password);
        
        
        // 2. 실제 검증. authenticate() 메서드를 통해 요청된 Member 에 대한 검증 진행
        // authenticate 메서드가 실행될 때 CustomUserDetailsService 에서 만든 loadUserByUsername 메서드 실행
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        
        // 3. 인증 정보를 기반으로 JWT 토큰 생성
        return jwtTokenProvider.generateToken(authentication);
	}
	
	@Override
	public Member createMember(MemberFactory memberCommandFactory) throws DuplicateMemberEmailException, DuplicateMemberLoginIdException {
		SignUp signUp = memberCommandFactory.getMember(InternalParameterForMember.builder().encoder(encoder).memberRepository(memberRepository).build());
		
		//TODO : Exception customizing
		return memberRepository.save(signUp.execute());
	}
}