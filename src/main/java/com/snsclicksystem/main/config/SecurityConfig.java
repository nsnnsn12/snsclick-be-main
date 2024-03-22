package com.snsclicksystem.main.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.snsclicksystem.main.auth.exception.JwtAccessDeniedHandler;
import com.snsclicksystem.main.auth.exception.JwtAuthenticationEntryPoint;
import com.snsclicksystem.main.auth.jwt.JwtAuthenticationFilter;
import com.snsclicksystem.main.auth.jwt.JwtTokenProvider;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor
public class SecurityConfig {

	private final JwtTokenProvider tokenProvider;
	private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
	private final JwtAccessDeniedHandler jwtAccessDeniedHandler;

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.csrf(AbstractHttpConfigurer::disable)
				
				.exceptionHandling((handling) -> handling.authenticationEntryPoint(jwtAuthenticationEntryPoint)
						.accessDeniedHandler(jwtAccessDeniedHandler))
				
				.headers((header) -> header.frameOptions(HeadersConfigurer.FrameOptionsConfig::sameOrigin))
				
				// 토큰을 활욜하면 세션이 필요 없어지므로 STATELESS 로 설정.
				.sessionManagement((session) -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				
				.authorizeHttpRequests(
						registry -> registry.requestMatchers("/auth/**", "member/**").permitAll()
						.anyRequest().authenticated()
						)
				
				// spring security default 파라미터 값 username 변경
				.formLogin(
						formLogin ->formLogin.usernameParameter("loginId") 
						)		
				
				// JWT 인증을 위해 직접 구현한 필터를 UsernamePasswordAuthenticationFilter 전에 실행
				.addFilterBefore(new JwtAuthenticationFilter(tokenProvider),
						UsernamePasswordAuthenticationFilter.class)
				;

		return httpSecurity.build();
	}
}
