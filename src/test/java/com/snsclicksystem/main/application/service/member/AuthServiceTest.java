package com.snsclicksystem.main.application.service.member;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.transaction.annotation.Transactional;

import com.snsclicksystem.main.auth.dto.ResponseToken;
import com.snsclicksystem.main.domain.member.Member;
import com.snsclicksystem.main.domain.member.dto.MemberInfo;
import com.snsclicksystem.main.domain.member.exception.DuplicateMemberInfoException;
import com.snsclicksystem.main.domain.member.exception.MemberNotFoundException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Transactional
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AuthServiceTest {

	@Autowired
	AuthService authService;
	
	@Autowired
	MemberService memberService;
	
	@Autowired
	TestRestTemplate testRestTemplate;
	
	@LocalServerPort
	int randomServerPort;
	
	
	@BeforeEach
	void createMember() throws DuplicateMemberInfoException {
		MemberInfo memberInfo = MemberInfo.builder()
										  .username("aa")
										  .password("aa")
										  .email("@@")
										  .build();
		
		Member member = memberService.createMember(memberInfo);
	}
	
	@Test
	void signInTest() throws MemberNotFoundException {
		String username = "aa";
		String password = "aa";
		
		ResponseToken responseToken = authService.signIn(username, password);
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setBearerAuth(responseToken.getAccessToken());
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		
		log.info("httpHeaders = {}", httpHeaders);
		
		/*
		String url = "http://localhost:" + randomServerPort + "/auth/test";
		ResponseEntity<String> responseEntity = testRestTemplate.postForEntity(url, new HttpEntity<>(httpHeaders), String.class);
		
		assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(responseEntity.getBody()).isEqualTo(username);
		*/
	}
	
	/* Controller Test Code
    @PostMapping("/test")
    public String test() {
        return SecurityUtil.getCurrentUsername();
    }
    
	public class SecurityUtil {
	    public static String getCurrentUsername() {
	        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	        if (authentication == null || authentication.getName() == null) {
	            throw new RuntimeException("No authentication information.");
	        }
	        return authentication.getName();
	    }
	}
	*/
	
	@Test
	void wrongUsernameSignInTest() throws MemberNotFoundException {
		String username = "aaa";
		String password = "aa";
		
		Assertions.assertThatThrownBy(() -> authService.signIn(username, password))
        .isInstanceOf(MemberNotFoundException.class);
	}
	
	@Test
	void wrongPasswordSignInTest() throws MemberNotFoundException {
		String username = "aa";
		String password = "aaa";
		
		Assertions.assertThatThrownBy(() -> authService.signIn(username, password))
        .isInstanceOf(BadCredentialsException.class);
	}
	
}
