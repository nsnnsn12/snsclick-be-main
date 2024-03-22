package com.snsclicksystem.main.adapter.in.member;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.snsclicksystem.main.adapter.in.common.NoCreateException;
import com.snsclicksystem.main.adapter.in.member.dto.RequestSignUp;
import com.snsclicksystem.main.adapter.in.member.dto.ResponseSignUp;
import com.snsclicksystem.main.application.port.in.member.MemberUseCase;
import com.snsclicksystem.main.domain.member.dto.MemberInfo;
import com.snsclicksystem.main.domain.member.exception.DuplicateMemberEmailException;
import com.snsclicksystem.main.domain.member.exception.DuplicateMemberLoginIdException;
import com.snsclicksystem.main.util.modelmapper.ObjectMapper;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {
	
    private final MemberUseCase memberUseCase;
    private final ObjectMapper objectMapper;
	
    @PostMapping("/signUp")
    public ResponseEntity<ResponseSignUp> signUp(@Valid @RequestBody RequestSignUp request) throws DuplicateMemberEmailException, DuplicateMemberLoginIdException {
		try {
			return new ResponseEntity<>(objectMapper.convert(memberUseCase.createMember(getMemberInfo(request)), ResponseSignUp.class), HttpStatus.OK);
		} catch(DuplicateMemberEmailException | DuplicateMemberLoginIdException e) {
			throw new NoCreateException(e.getMessage());
		}
    	
    }
    
    private MemberInfo getMemberInfo (RequestSignUp request) {
    	return MemberInfo.builder()
    					 .loginId(request.getLoginId()) 
    					 .password(request.getPassword())
    					 .email(request.getEmail())
    					 .build();
    }

}
