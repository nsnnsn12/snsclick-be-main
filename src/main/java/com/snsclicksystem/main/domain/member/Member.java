package com.snsclicksystem.main.domain.member;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Member {
	private Long id;
	private String email;
	private Long totalAmount;
}
