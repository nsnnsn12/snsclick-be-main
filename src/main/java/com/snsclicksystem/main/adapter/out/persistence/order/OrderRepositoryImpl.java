package com.snsclicksystem.main.adapter.out.persistence.order;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.snsclicksystem.main.adapter.out.persistence.item.ItemEntity;
import com.snsclicksystem.main.adapter.out.persistence.item.ItemJPARepository;
import com.snsclicksystem.main.adapter.out.persistence.member.repository.MemberEntity;
import com.snsclicksystem.main.adapter.out.persistence.member.repository.MemberJPARepository;
import com.snsclicksystem.main.adapter.out.persistence.transaction_history.TransactionHistoryEntity;
import com.snsclicksystem.main.adapter.out.persistence.transaction_history.TransactionHistoryJPARepository;
import com.snsclicksystem.main.domain.order.dto.OrderedInfoDto;
import org.springframework.stereotype.Repository;

import com.snsclicksystem.main.application.port.out.persistence.order.OrderRepository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryImpl implements OrderRepository{
	private final TransactionHistoryJPARepository transactionHistoryJPARepository;
	private final MemberJPARepository memberJPARepository;
	private final ItemJPARepository itemJPARepository;
	private final OrderJPARepository jpaRepository;
	private final JPAQueryFactory jpaQueryFactory;
	@Override
	public OrderedInfoDto save(OrderedInfoDto order) {
		OrderEntity savedOrder = jpaRepository.save(toEntity(order));
		order.saveId(savedOrder.getId());
		return order;
	}

	private OrderEntity toEntity(OrderedInfoDto orderedInfoDto) {
		MemberEntity member = memberJPARepository.getReferenceById(orderedInfoDto.getMemberId());
		ItemEntity item = itemJPARepository.getReferenceById(orderedInfoDto.getItem().getId());
		TransactionHistoryEntity transactionHistoryEntity = transactionHistoryJPARepository.getReferenceById(orderedInfoDto.getTransactionHistory().getId());

		return OrderEntity.builder()
				.member(member)
				.transactionHistory(transactionHistoryEntity)
				.item(item)
				.targetLink(orderedInfoDto.getTargetLink())
				.orderBeforeQuantity(orderedInfoDto.getOrderBeforeQuantity())
				.completedStatus(orderedInfoDto.isCompletedStatus())
				.orderQuantity(orderedInfoDto.getOrderQuantity())
				.externalOrderedId(orderedInfoDto.getExternalOrderedId())
				.build();
	}
}
