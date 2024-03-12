package com.snsclicksystem.main.application.service.charge;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.snsclicksystem.main.adapter.out.persistence.charge.ChargeEntity;
import com.snsclicksystem.main.adapter.out.persistence.member.MemberEntity;
import com.snsclicksystem.main.application.port.in.charge.ChargeRequestFailException;
import com.snsclicksystem.main.application.port.in.charge.ChargeUseCase;
import com.snsclicksystem.main.application.port.out.api.charge.ChargeApi;
import com.snsclicksystem.main.application.port.out.persistence.charge.ChargeRepository;
import com.snsclicksystem.main.application.port.out.persistence.member.MemberRepository;
import com.snsclicksystem.main.domain.charge.Charge;

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
	public Charge requestCharge(Charge charge) throws ChargeRequestFailException{
		//member create (TODO : DELETE)
		memberRepository.save(new MemberEntity("ddd@gmail.com"));
		
		// find member
		MemberEntity member = memberRepository.findEntityById(charge.getMemberId()).get();
		
		// create chargeEntity 
		ChargeEntity chargeEntity = ChargeEntity.createChargeEntity(charge,member);
		
		// save request charge
		Charge savedCharge = chargeRepository.save(chargeEntity);
		
		// set url from return request charge
		savedCharge.setSuccessUrl(StringUtils.hasText(charge.getSuccessUrl()) ? charge.getSuccessUrl() : chargeApi.getSuccessUrl());
		savedCharge.setFailUrl(StringUtils.hasText(charge.getFailUrl()) ? charge.getFailUrl() : chargeApi.getFailUrl());
		
		//set member email
		savedCharge.setMemberEmail(member.getEmail());
		
		return savedCharge;
	}

}
