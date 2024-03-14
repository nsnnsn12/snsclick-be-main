package com.snsclicksystem.main.application.port.in.charge;

import com.snsclicksystem.main.application.service.charge.ChargeFactory;
import com.snsclicksystem.main.domain.charge.exception.ChargeRequestFailException;
import com.snsclicksystem.main.domain.charge.dto.ChargedInfo;

public interface ChargeUseCase {

	ChargedInfo requestCharge(ChargeFactory chargeFactory) throws ChargeRequestFailException;

}
