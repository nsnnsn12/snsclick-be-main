package com.snsclicksystem.main.adapter.out.persistence.transaction_history;

import com.snsclicksystem.main.adapter.out.persistence.member.MemberEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

@Entity(name = "transaction_history")
@Getter
@Builder
public class TransactionHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_history_id")
    private Long id;

    @ManyToOne(fetch =FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private MemberEntity member;
}
