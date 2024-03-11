package com.snsclicksystem.main.adapter.in.charge.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseCharge {
	
	private String payType;			//결제 타입

	private Long amount;			//금액
	
	private Long orderId;			//주문ID (우리는 주문형식이 아닌, 충전 형식이여서 주문id가 아닌 충전id 리턴)
	
	
	private String orderName;		// constant : 포인트 충전
	
	private String customerName;	//고객이름 (memberId로 대체)
	
	private String customerEmail;	//고객이메일 (memberEmail)
	
	private String successUrl;		//성공 시 리다이렉트 url 
	
	private String failUrl; 		//실패 시 리다이렉트 url 
	
	private String failReason;		//실패 이유
	
	private Boolean cancelYN;		//취소YN
	
	private String cancelReason;	//취소 이유
	
	private LocalDateTime createdAt;		//충전 시간

}
