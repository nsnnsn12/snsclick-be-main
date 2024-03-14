package com.snsclicksystem.main.domain.charge;


import com.snsclicksystem.main.application.service.charge.ChargeParameter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class ChargeFactory {
	public abstract Charge getCharge(ChargeParameter parameter);
}
