package com.snsclicksystem.main.adapter.out.persistence.charge;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.snsclicksystem.main.application.port.out.persistence.charge.ChargeRepository;
import com.snsclicksystem.main.domain.charge.Charge;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ChargeRepositoryImpl implements ChargeRepository {
    private final ChargeJPARepository jpaRepository;
    private final JPAQueryFactory jpaQueryFactory;
  
	@Override
	public Charge save(ChargeEntity entity) {
		ChargeEntity saveEntity = jpaRepository.save(entity);
		return getChargeFromModel(saveEntity);
	}
	
	private Charge getChargeFromModel(ChargeEntity entity) {
		return Charge.builder().id(entity.getId())
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
