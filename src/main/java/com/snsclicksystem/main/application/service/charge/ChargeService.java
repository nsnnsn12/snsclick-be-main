package com.snsclicksystem.main.application.service.charge;


import com.snsclicksystem.main.domain.charge.dto.ChargedInfo;
import com.snsclicksystem.main.domain.member.MemberInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.snsclicksystem.main.domain.charge.exception.ChargeRequestFailException;
import com.snsclicksystem.main.application.port.in.charge.ChargeUseCase;
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

	/*
	 * 결제 요청 service
	 */
	@Override
	public ChargedInfo requestCharge(ChargeFactory chargeFactory) throws ChargeRequestFailException{
		//member create (TODO : DELETE)
//		memberRepository.save(new MemberEntity("ddd@gmail.com"));


		//사용자를 가져온다.
		//아마 authentication 이용해서 사용자 id나 email 받은 다음 그 정보로 조회하면 될 것 같습니다.
//		MemberEntity member = memberRepository.findEntityById(charge.getMemberId()).get();
		MemberInfo member = MemberInfo.builder().build();
		//충전 시 필요한 파라미터를 받아 충전 객체를 생성한다.
		Charge charge = chargeFactory.getCharge(InternalParameterForCharge.builder().member(member).build());

		//충전을 한다.
		ChargedInfo chargedInfo = charge.execute();


		//충전한 정보를 저장한다.
		return chargeRepository.saveByChargedInfo(chargedInfo);
	}

}
