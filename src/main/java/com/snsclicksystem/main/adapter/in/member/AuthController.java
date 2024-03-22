package com.snsclicksystem.main.adapter.in.member;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.snsclicksystem.main.adapter.in.common.NoSearchException;
import com.snsclicksystem.main.adapter.in.member.dto.RequestSignIn;
import com.snsclicksystem.main.adapter.in.member.dto.ResponseSignIn;
import com.snsclicksystem.main.application.port.in.member.AuthUseCase;
import com.snsclicksystem.main.domain.member.exception.MemberNotFoundException;
import com.snsclicksystem.main.util.modelmapper.ObjectMapper;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
@Slf4j
public class AuthController {

    private final AuthUseCase authUseCase;
    private final ObjectMapper objectMapper;

    @PostMapping("/signIn")
    public ResponseEntity<ResponseSignIn> signIn(@Valid @RequestBody RequestSignIn request) throws MemberNotFoundException {
        try {
			return new ResponseEntity<>(objectMapper.convert(authUseCase.signIn(request.getLoginId(),request.getPassword()), ResponseSignIn.class),
					HttpStatus.OK);
		} catch (MemberNotFoundException e) {
			throw new NoSearchException(e.getMessage());
		}
    }

}