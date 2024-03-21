package com.snsclicksystem.main.adapter.out.persistence.transaction_history;

import com.snsclicksystem.main.adapter.out.persistence.common.BaseTimeEntity;
import com.snsclicksystem.main.adapter.out.persistence.member.MemberEntity;
import com.snsclicksystem.main.domain.transaction_history.TransactionType;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

@Entity(name = "transaction_history")
@Getter
@Builder
public class TransactionHistoryEntity extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_history_id")
    private Long id;

    @ManyToOne(fetch =FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private MemberEntity member;

    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;

    @Column(name = "transaction_amount")
    private Long amount;
}
