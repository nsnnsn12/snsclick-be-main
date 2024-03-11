package com.snsclicksystem.main.adapter.out.persistence.member;


import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.snsclicksystem.main.adapter.out.persistence.member.MemberJPARepository;
import com.snsclicksystem.main.application.port.out.persistence.member.MemberRepository;
import com.snsclicksystem.main.domain.item.SnsItem;
import com.snsclicksystem.main.domain.member.Member;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepository {
	
	private final MemberJPARepository jpaRepository;
	
	
	@Override
	public int findTotAmountById(Long memberId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Optional<Member> findById(Long id) {
		Optional<MemberEntity> member = jpaRepository.findById(id);
		return member.map(this::getMemberFromModel);
	}
	
	@Override
	public Optional<MemberEntity> findEntityById(Long id) {
		return jpaRepository.findById(id);
	}
	
	 private Member getMemberFromModel(MemberEntity entity){
	        return Member.builder().email(entity.getEmail()).build();
	    }

	@Override
	public void save(MemberEntity memberEntity) {
		jpaRepository.save(memberEntity);
	}



}
