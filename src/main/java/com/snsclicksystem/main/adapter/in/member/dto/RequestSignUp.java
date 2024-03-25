package com.snsclicksystem.main.adapter.in.member.dto;

import com.snsclicksystem.main.domain.member.enums.MemberType;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestSignUp {
	
	@NotNull
	private String username;
	
	@NotNull
	private String password;
	
	@NotNull
	private String email;
	

}
