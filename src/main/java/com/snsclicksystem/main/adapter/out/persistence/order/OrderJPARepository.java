package com.snsclicksystem.main.adapter.out.persistence.order;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderJPARepository extends JpaRepository<OrderEntity, Long> {
}
