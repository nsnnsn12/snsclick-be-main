package com.snsclicksystem.main.application.port.out.persistence.order;
import com.snsclicksystem.main.domain.order.dto.OrderedInfo;
import com.snsclicksystem.main.domain.transaction_history.TransactionHistory;

public interface OrderRepository {

	OrderedInfo save(OrderedInfo order, TransactionHistory transactionHistory);

}
