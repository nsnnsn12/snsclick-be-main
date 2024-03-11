package com.snsclicksystem.main.adapter.out.persistence.charge;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.snsclicksystem.main.adapter.in.charge.dto.RequestCharge;
import com.snsclicksystem.main.adapter.out.persistence.item.ItemEntity;
import com.snsclicksystem.main.application.port.out.persistence.charge.RequestChargeCriteria;
import com.snsclicksystem.main.application.port.out.persistence.charge.ChargeRepository;
import com.snsclicksystem.main.application.port.out.persistence.item.ItemCriteria;
import com.snsclicksystem.main.application.port.out.persistence.item.ItemRepository;
import com.snsclicksystem.main.domain.charge.Charge;
import com.snsclicksystem.main.domain.item.SnsItem;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;


@Repository
@RequiredArgsConstructor
public class ChargeRepositoryImpl implements ChargeRepository {
    private final ChargeJPARepository jpaRepository;
    private final JPAQueryFactory jpaQueryFactory;
  
	@Override
	public Charge save(RequestChargeCriteria charge) {
		ChargeEntity entity = ChargeEntity.toEntity(charge);
		ChargeEntity saveEntity = jpaRepository.save(entity);
		return getChargeFromModel(saveEntity);
	}
	
	private Charge getChargeFromModel(ChargeEntity entity) {
		return Charge.builder().id(entity.getId())
				.chargeType(entity.getChargeType().toString())
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
