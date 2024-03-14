package com.snsclicksystem.main.domain.charge.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Builder
@ToString
public class ChargedInfo {
	
	private Long id;
	
	private String chargeType;
	
	private Long realAmountPaid;
	
	private String cancelReason;
	
	private Boolean isCancel;
	
	private String failReason;
	
	private Boolean isPaySuccess;
	
	private String chargeApiId;
	
	private LocalDateTime createdAt;
	
	private String successUrl;
	
	private String failUrl;
	
	private Long memberId;
	
	private String memberEmail;
	
	public void setSuccessUrl(String successUrl) {
		this.successUrl = successUrl;
	}
	
	public void setFailUrl(String failUrl) {
		this.failUrl = failUrl;
	}
	
	public void setMemberEmail(String email) {
		this.memberEmail = email;
	}
}
