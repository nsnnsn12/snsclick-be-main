package com.snsclicksystem.main.application.port.out.persistence.charge;

import java.util.Optional;

import com.snsclicksystem.main.domain.charge.Charge;

public interface ChargeRepository {

	Charge save(RequestChargeCriteria charge);


}
