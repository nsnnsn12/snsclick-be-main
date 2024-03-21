package com.snsclicksystem.main.application.port.out.persistence.transaction_history;

import com.snsclicksystem.main.domain.transaction_history.TransactionHistory;

public interface TransactionHistoryRepository {
	TransactionHistory save(TransactionHistory order);
}
