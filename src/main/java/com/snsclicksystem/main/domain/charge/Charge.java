package com.snsclicksystem.main.domain.charge;

import java.time.LocalDateTime;

import com.snsclicksystem.main.adapter.in.charge.dto.RequestCharge;
import com.snsclicksystem.main.config.TossPaymentConfig;
import com.snsclicksystem.main.domain.member.Member;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class Charge {
	
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
	
	public static Charge createRequestCharge(Long memberId, String chargeType, Long realAmountPaid, String successUrl, String failUrl) {
		return Charge.builder().memberId(memberId)
		.chargeType(chargeType)
		.realAmountPaid(realAmountPaid)
		.successUrl(successUrl)
		.failUrl(failUrl).build();
	}

}
