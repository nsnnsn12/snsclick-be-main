package com.snsclicksystem.main.adapter.out.persistence.charge;

import com.snsclicksystem.main.adapter.out.persistence.common.BaseTimeEntity;
import com.snsclicksystem.main.adapter.out.persistence.member.repository.MemberEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Getter;

@Entity(name = "charge")
@Getter
@Builder
public class ChargeEntity extends BaseTimeEntity{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "charge_id")
	private Long id;
	
	@ManyToOne(fetch =FetchType.LAZY)
	@JoinColumn(name = "member_id")
	private MemberEntity member;
	
	private String chargeType;
	
	private Long realAmountPaid;
	
	private String cancelReason;
	
	@Column(nullable = false, name = "cancel_YN")
	private Boolean isCancel;
	
	private String failReason;
	
	@Column(nullable = false, name = "chargeSuccess_YN")
	private Boolean isPaySuccess;
	
	private String chargeApiId;
}
