package com.snsclicksystem.main.adapter.in.charge.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RequestCharge {
	
	@NonNull
	private Long memberId;
	
	@NonNull
	private ChargeType chargeType;
	
	@NonNull
	private Long realAmountPaid;

	private String mySuccessUrl;
	
	private String myFailUrl;
}
