package com.snsclicksystem.main.adapter.in.charge.factory;


import com.snsclicksystem.main.adapter.in.charge.dto.RequestCharge;
import com.snsclicksystem.main.adapter.out.api.charge.command.TossPaymentCharge;
import com.snsclicksystem.main.domain.charge.Charge;
import com.snsclicksystem.main.domain.charge.ChargeFactory;
import com.snsclicksystem.main.application.service.charge.ChargeParameter;

/**
 * 토스 결제를 위한 객체를 만드는 클래스
 * 사용자에게 받은 정보를 가지고 있다.
 * 서비스 레이어에서 파라미터를 보내 charge 객체를 요청할 때 만들어 주는 역할을 한다.
 */
public class TossPaymentChargeFactory extends ChargeFactory {

	public TossPaymentChargeFactory(RequestCharge requestCharge) {
		//TODO requestCharge에서 토스 결제를 위한 정보를 추출하여 TossPaymentCharge 객체를 생성할 때 사용해야 한다.
	}

	@Override
	public Charge getCharge(ChargeParameter parameter) {
		//TODO 외부에서 전달받은 requestCharge와 내부에서 전달받은 ChargeParameter를 합쳐서 TossPaymentCharge 객체를 생성해야 한다.
		TossPaymentCharge tossPaymentCharge = new TossPaymentCharge(parameter);
		return tossPaymentCharge;
	}
}
