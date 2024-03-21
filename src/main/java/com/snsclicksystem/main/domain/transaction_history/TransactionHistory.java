package com.snsclicksystem.main.domain.transaction_history;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class TransactionHistory {
    private Long id;
    private Long memberId;
    private TransactionType transactionType;
    private Long amount;

    public void saveId(Long id) {
        this.id = id;
    }
}
