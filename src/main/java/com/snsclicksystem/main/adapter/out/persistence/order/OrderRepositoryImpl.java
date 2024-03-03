package com.snsclicksystem.main.adapter.out.persistence.order;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.snsclicksystem.main.adapter.in.order.dto.RequestOrder;
import com.snsclicksystem.main.adapter.out.persistence.item.ItemJPARepository;
import com.snsclicksystem.main.application.port.out.persistence.order.OrderRepository;
import com.snsclicksystem.main.domain.order.SnsOrder;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryImpl implements OrderRepository{
	
	@Override
	public Optional<SnsOrder> save(RequestOrder order) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

}
