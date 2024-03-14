package com.snsclicksystem.main.domain.charge;


import com.snsclicksystem.main.application.service.charge.InternalParameterForCharge;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class ChargeFactory {
	public abstract Charge getCharge(InternalParameterForCharge parameter);
}
