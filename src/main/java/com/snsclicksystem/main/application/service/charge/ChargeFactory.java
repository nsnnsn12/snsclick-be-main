package com.snsclicksystem.main.application.service.charge;


import com.snsclicksystem.main.domain.charge.Charge;

public interface ChargeFactory {
	Charge getCharge(InternalParameterForCharge parameter);
}
