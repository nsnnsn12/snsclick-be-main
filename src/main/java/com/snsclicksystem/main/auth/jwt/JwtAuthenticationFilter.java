package com.snsclicksystem.main.auth.jwt;

import java.io.IOException;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.GenericFilterBean;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
public class JwtAuthenticationFilter extends GenericFilterBean {

	public static final String AUTHORIZATION_HEADER = "Authorization";

	private final JwtTokenProvider jwtProvider;

	/**
	 * 1. Request Header에서 토큰 정보 추출 
	 * 2. 토큰 정보가 있으면 JwtTokenProvider 의 validToken 를 통해 유효성 검사 
	 * 3. 토큰이 유효하면 토큰에서 Authentication 객체를 Security Context 에 저장
	 *
	 * @param request
	 * @param response
	 * @param chain
	 * @throws IOException
	 * @throws ServletException
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// Request Header 에서 토큰 추출
		String accessToken = resolveToken((HttpServletRequest) request);
		// 토큰 정보가 있으면 유효성 검사
		if (StringUtils.hasText(accessToken) && jwtProvider.validateToken(accessToken)) {
			// Authentication 객체를 꺼냄
			Authentication authentication = jwtProvider.getAuthentication(accessToken);
			// Security Context 에 저장
			SecurityContextHolder.getContext().setAuthentication(authentication);
		}
		chain.doFilter(request, response);
	}
	
	/**
	 * 1. Request Header에서 토큰 정보 추출 

	 *
	 * @param request
	 * @return 
	 */
	private String resolveToken(HttpServletRequest request) {
		String bearerToken = request.getHeader(AUTHORIZATION_HEADER);
		if(StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
			return bearerToken.substring(7);
		}
		return null;
	}

}
