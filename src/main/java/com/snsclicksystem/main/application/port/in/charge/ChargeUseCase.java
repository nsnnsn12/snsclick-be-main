package com.snsclicksystem.main.application.port.in.charge;

import com.snsclicksystem.main.adapter.in.charge.dto.RequestCharge;
import com.snsclicksystem.main.domain.charge.Charge;

public interface ChargeUseCase {
	
	Charge requestCharge(RequestCharge charge);

}
