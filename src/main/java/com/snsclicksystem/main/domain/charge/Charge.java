package com.snsclicksystem.main.domain.charge;


import com.snsclicksystem.main.application.service.charge.InternalParameterForCharge;
import com.snsclicksystem.main.domain.charge.dto.ChargedInfo;
import com.snsclicksystem.main.domain.charge.exception.ChargeRequestFailException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class Charge {
	protected final InternalParameterForCharge parameter;

	public ChargedInfo execute() throws ChargeRequestFailException {
		//TODO 충전이라는 행위 전후에 처리해야 하는 비즈니스 로직이 있는 경우 작성 필요
		return charge();
	}

	//TODO 이 부분에 각각의 자식 클래스가 필요한 충전 방식을 구현
	protected abstract ChargedInfo charge() throws ChargeRequestFailException;
}
