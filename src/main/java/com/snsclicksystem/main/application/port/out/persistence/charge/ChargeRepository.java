package com.snsclicksystem.main.application.port.out.persistence.charge;


import com.snsclicksystem.main.adapter.out.persistence.charge.ChargeEntity;
import com.snsclicksystem.main.domain.charge.Charge;

public interface ChargeRepository {

	Charge save(ChargeEntity chargeEntity);



}
