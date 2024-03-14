package com.snsclicksystem.main.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.snsclicksystem.main.auth.exception.JwtAccessDeniedHandler;
import com.snsclicksystem.main.auth.exception.JwtAuthenticationEntryPoint;
import com.snsclicksystem.main.auth.jwt.JwtSecurityConfig;
import com.snsclicksystem.main.auth.jwt.JwtTokenProvider;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(        
		securedEnabled = true,
		jsr250Enabled = true,
		prePostEnabled = true
)
@RequiredArgsConstructor
public class SecurityConfig {

	private final JwtTokenProvider tokenProvider;
	private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
	private final JwtAccessDeniedHandler jwtAccessDeniedHandler;
	
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
		httpSecurity
				.csrf(AbstractHttpConfigurer::disable)

				.exceptionHandling((handling) -> 
						handling.authenticationEntryPoint(jwtAuthenticationEntryPoint)
								.accessDeniedHandler(jwtAccessDeniedHandler)
				)

				.headers((header) -> 
					header.frameOptions(
								HeadersConfigurer.FrameOptionsConfig::sameOrigin
					)
				)
				
				// 토큰을 활욜하면 세션이 필요 없어지므로 STATELESS 로 설정.
				.sessionManagement((session) -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				
				.authorizeHttpRequests((registry) -> 
						registry.requestMatchers(
								new AntPathRequestMatcher("/charge/**")).permitAll()
								// TODO : test용 으로 h2 사용. 추후, postgresql로 변경
								.requestMatchers(PathRequest.toH2Console()).permitAll()
								.anyRequest().authenticated()
								
				)
				.with(new JwtSecurityConfig(tokenProvider), customizer -> {});
		
		return httpSecurity.build();
	}
}
