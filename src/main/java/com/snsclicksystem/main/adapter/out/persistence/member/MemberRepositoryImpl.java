package com.snsclicksystem.main.adapter.out.persistence.member;

import org.springframework.stereotype.Repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.snsclicksystem.main.adapter.out.persistence.item.ItemJPARepository;
import com.snsclicksystem.main.application.port.out.persistence.member.MemberRepository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepository{@Override
	public int findTotAmountById(Long memberId) {
		// TODO Auto-generated method stub
		return 0;
	}

}
