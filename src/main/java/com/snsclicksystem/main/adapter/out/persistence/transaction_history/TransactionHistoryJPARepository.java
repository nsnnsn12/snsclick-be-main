package com.snsclicksystem.main.adapter.out.persistence.transaction_history;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionHistoryJPARepository extends JpaRepository<TransactionHistoryEntity, Long> {
}
