package com.snsclicksystem.main.adapter.in.member.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString	
public class RequestSignIn {

	@NotNull
	private String loginId;
	
	@NotNull
	private String password;
	
}
