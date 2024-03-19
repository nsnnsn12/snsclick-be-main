package com.snsclicksystem.main.adapter.out.persistence.transaction_history;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.snsclicksystem.main.adapter.out.persistence.member.MemberEntity;
import com.snsclicksystem.main.adapter.out.persistence.member.MemberJPARepository;
import com.snsclicksystem.main.application.port.out.persistence.transaction_history.TransactionHistoryRepository;
import com.snsclicksystem.main.domain.transaction_history.TransactionHistory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class TransactionHistoryRepositoryImpl implements TransactionHistoryRepository {
    private final TransactionHistoryJPARepository jpaRepository;
    private final MemberJPARepository memberJPARepository;
    private final JPAQueryFactory jpaQueryFactory;

    public TransactionHistory save(TransactionHistory transactionHistory) {
        TransactionHistoryEntity save = jpaRepository.save(toEntity(transactionHistory));
        return toDomain(save);
    }

    private TransactionHistory toDomain(TransactionHistoryEntity entity) {
        return TransactionHistory.builder()
                .id(entity.getId())
                .memberId(entity.getMember().getId())
                .transactionType(entity.getTransactionType())
                .amount(entity.getAmount())
                .build();
    }

    private TransactionHistoryEntity toEntity(TransactionHistory transactionHistory) {
        MemberEntity member = memberJPARepository.getReferenceById(transactionHistory.getMemberId());
        return TransactionHistoryEntity.builder()
                .id(transactionHistory.getId())
                .member(member)
                .transactionType(transactionHistory.getTransactionType())
                .amount(transactionHistory.getAmount())
                .build();
    }
}
