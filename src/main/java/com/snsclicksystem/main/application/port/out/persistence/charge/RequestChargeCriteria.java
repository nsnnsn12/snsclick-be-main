package com.snsclicksystem.main.application.port.out.persistence.charge;

import java.time.LocalDateTime;

import com.snsclicksystem.main.adapter.out.persistence.member.MemberEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestChargeCriteria {
	
	private String chargeType;
	
	private Long realAmountPaid;
	
	private MemberEntity member;
}
