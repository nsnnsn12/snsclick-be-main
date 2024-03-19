package com.snsclicksystem.main.application.service.charge;


import com.snsclicksystem.main.domain.member.Member;
import lombok.Builder;
import lombok.Getter;

/**
 * 충전 시 서비스 레이어에서 전달받는 파라미터 정보
 */
@Builder
@Getter
public class InternalParameterForCharge {
	private Member member;
}
