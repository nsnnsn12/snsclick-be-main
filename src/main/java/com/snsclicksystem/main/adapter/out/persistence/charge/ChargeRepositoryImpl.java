package com.snsclicksystem.main.adapter.out.persistence.charge;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.snsclicksystem.main.application.port.out.persistence.charge.ChargeRepository;
import com.snsclicksystem.main.domain.charge.dto.ChargedInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ChargeRepositoryImpl implements ChargeRepository {
    private final ChargeJPARepository jpaRepository;
    private final JPAQueryFactory jpaQueryFactory;

	public ChargedInfo saveByChargedInfo(ChargedInfo chargedInfo) {
		ChargeEntity save = jpaRepository.save(fromChargedInfo(chargedInfo));
		return toChargedInfo(save);
	}

	private ChargeEntity fromChargedInfo(ChargedInfo chargedInfo){
		//TODO need to implement
		return null;
	}

	private ChargedInfo toChargedInfo(ChargeEntity entity) {
		return ChargedInfo.builder().id(entity.getId())
				.chargeType(entity.getChargeType())
				.realAmountPaid(entity.getRealAmountPaid())
				.cancelReason(entity.getCancelReason())
				.isCancel(entity.getIsCancel())
				.failReason(entity.getFailReason())
				.isPaySuccess(entity.getIsPaySuccess())
				.chargeApiId(entity.getChargeApiId())
				.createdAt(entity.getCreatedAt())
				.build();
	}
	
 
}
