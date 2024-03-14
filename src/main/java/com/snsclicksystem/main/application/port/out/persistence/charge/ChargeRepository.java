package com.snsclicksystem.main.application.port.out.persistence.charge;


import com.snsclicksystem.main.domain.charge.dto.ChargedInfo;

public interface ChargeRepository {
	ChargedInfo saveByChargedInfo(ChargedInfo chargedInfo);
}
