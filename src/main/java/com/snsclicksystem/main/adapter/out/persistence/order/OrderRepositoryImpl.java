package com.snsclicksystem.main.adapter.out.persistence.order;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.snsclicksystem.main.adapter.out.persistence.item.ItemEntity;
import com.snsclicksystem.main.adapter.out.persistence.item.ItemJPARepository;
import com.snsclicksystem.main.adapter.out.persistence.member.MemberEntity;
import com.snsclicksystem.main.adapter.out.persistence.member.MemberJPARepository;
import com.snsclicksystem.main.adapter.out.persistence.transaction_history.TransactionHistoryEntity;
import com.snsclicksystem.main.adapter.out.persistence.transaction_history.TransactionHistoryJPARepository;
import com.snsclicksystem.main.domain.order.dto.OrderedInfo;
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
	public OrderedInfo save(OrderedInfo order) {
		OrderEntity savedOrder = jpaRepository.save(toEntity(order));
		return toDomain(savedOrder, order);
	}

	private OrderedInfo toDomain(OrderEntity entity, OrderedInfo order) {
		return OrderedInfo.builder()
				.id(entity.getId())
				.item(order.getItem())
				.transactionHistory(order.getTransactionHistory())
				.memberId(order.getMemberId())
				.externalOrderId(order.getExternalOrderId())
				.targetLink(order.getTargetLink())
				.orderBeforeQuantity(order.getOrderBeforeQuantity())
				.completedStatus(order.isCompletedStatus())
				.orderQuantity(order.getOrderQuantity())
				.build();
	}

	private OrderEntity toEntity(OrderedInfo orderedInfo) {
		MemberEntity member = memberJPARepository.getReferenceById(orderedInfo.getMemberId());
		ItemEntity item = itemJPARepository.getReferenceById(orderedInfo.getItem().getId());
		TransactionHistoryEntity transactionHistory = transactionHistoryJPARepository.getReferenceById(orderedInfo.getTransactionHistory().getId());

		return OrderEntity.builder()
				.member(member)
				.transactionHistory(transactionHistory)
				.item(item)
				.targetLink(orderedInfo.getTargetLink())
				.orderBeforeQuantity(orderedInfo.getOrderBeforeQuantity())
				.completedStatus(orderedInfo.isCompletedStatus())
				.orderQuantity(orderedInfo.getOrderQuantity())
				.build();
	}
}
