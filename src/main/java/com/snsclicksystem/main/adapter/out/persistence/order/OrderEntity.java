package com.snsclicksystem.main.adapter.out.persistence.order;

import com.snsclicksystem.main.adapter.out.persistence.common.BaseTimeEntity;
import com.snsclicksystem.main.adapter.out.persistence.item.ItemEntity;
import com.snsclicksystem.main.adapter.out.persistence.member.MemberEntity;
import com.snsclicksystem.main.adapter.out.persistence.transaction_history.TransactionHistory;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

@Entity(name = "orders")
@Getter
@Builder
public class OrderEntity extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;

    @ManyToOne(fetch =FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private MemberEntity member;

    @OneToOne
    @JoinColumn(name = "transaction_history_id")
    private TransactionHistory transactionHistory;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private ItemEntity item;

    private Long externalOrderId;
    private String targetLink;

    private Long orderBeforeQuantity;

    private boolean completedStatus;
}
