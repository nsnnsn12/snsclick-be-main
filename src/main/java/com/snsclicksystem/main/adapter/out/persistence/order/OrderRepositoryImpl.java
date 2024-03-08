package com.snsclicksystem.main.adapter.out.persistence.order;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.snsclicksystem.main.application.port.out.persistence.order.OrderRepository;
import com.snsclicksystem.main.domain.order.Order;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryImpl implements OrderRepository{
	
	@Override
	public Optional<Order> save(Order order) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

}