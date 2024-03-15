package com.snsclicksystem.main.auth.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class ResponseToken {
	private String accessToken;
	
	private String refreshToken;
	
	
}
