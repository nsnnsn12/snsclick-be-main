package com.snsclicksystem.main.adapter.out.api.charge.command;

import com.snsclicksystem.main.domain.charge.exception.ChargeRequestFailException;
import com.snsclicksystem.main.domain.charge.Charge;
import com.snsclicksystem.main.application.service.charge.ChargeParameter;
import com.snsclicksystem.main.domain.charge.dto.ChargedInfo;

public class TossPaymentCharge extends Charge {

    public TossPaymentCharge(ChargeParameter parameter) {
        super(parameter);
    }

    @Override
    protected ChargedInfo charge() throws ChargeRequestFailException {
        //TODO 토스 페이먼트 결제를 위한 로직 작성 필요
        return null;
    }
}
