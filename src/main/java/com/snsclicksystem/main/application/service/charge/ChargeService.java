package com.snsclicksystem.main.application.service.charge;


import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.snsclicksystem.main.adapter.in.charge.dto.RequestCharge;
import com.snsclicksystem.main.adapter.out.persistence.member.MemberEntity;
import com.snsclicksystem.main.application.port.in.charge.ChargeUseCase;
import com.snsclicksystem.main.application.port.out.persistence.charge.RequestChargeCriteria;
import com.snsclicksystem.main.application.port.out.api.charge.ChargeApi;
import com.snsclicksystem.main.application.port.out.persistence.charge.ChargeRepository;
import com.snsclicksystem.main.application.port.out.persistence.member.MemberRepository;
import com.snsclicksystem.main.domain.charge.Charge;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class ChargeService implements ChargeUseCase {

	private final MemberRepository memberRepository;
	private final ChargeRepository chargeRepository;
	private final ChargeApi chargeApi;
	
	/*
	 * 결제 요청 service
	 */
	@Override
	public Charge requestCharge(RequestCharge requestCharge) {
		//member create (TODO : DELETE)
		memberRepository.save(new MemberEntity("ddd@gmail.com"));
		
		// find member
		MemberEntity member = memberRepository.findEntityById(requestCharge.getMemberId()).get();
		
		// set save parameter
		RequestChargeCriteria charge = new RequestChargeCriteria();
		charge.setChargeType(requestCharge.getChargeType().toString());
		charge.setRealAmountPaid(requestCharge.getRealAmountPaid());
		charge.setMember(member);
		
		// save request charge
		Charge savedCharge = chargeRepository.save(charge);
		
		// set url from return request charge
		savedCharge.setSuccessUrl(StringUtils.hasText(requestCharge.getMySuccessUrl()) ? requestCharge.getMySuccessUrl() : chargeApi.getSuccessUrl());
		savedCharge.setFailUrl(StringUtils.hasText(requestCharge.getMyFailUrl()) ? requestCharge.getMyFailUrl() : chargeApi.getFailUrl());
		
		//set member email
		savedCharge.setMemberEmail(member.getEmail());
		
		return savedCharge;
	}

}
