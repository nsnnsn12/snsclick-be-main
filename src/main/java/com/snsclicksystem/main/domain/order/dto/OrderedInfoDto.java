package com.snsclicksystem.main.domain.order.dto;

import com.snsclicksystem.main.domain.item.Item;
import com.snsclicksystem.main.domain.transaction_history.TransactionHistory;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class OrderedInfoDto {
    private Long id;
    private Item item;
    private TransactionHistory transactionHistory;
    private Long memberId;
    private Long externalOrderedId;
    private String targetLink;
    private Long orderBeforeQuantity;
    private boolean completedStatus;
    private Integer orderQuantity;

    public void saveId(Long id) {
        this.id = id;
    }
    public void setTransactionHistory(TransactionHistory transactionHistory) {
        this.transactionHistory = transactionHistory;
    }
}
