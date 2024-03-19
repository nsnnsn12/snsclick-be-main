package com.snsclicksystem.main.adapter.out.persistence.member.repository;


import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.snsclicksystem.main.adapter.out.persistence.charge.ChargeEntity;
import com.snsclicksystem.main.application.port.out.persistence.member.MemberRepository;
import com.snsclicksystem.main.domain.charge.dto.ChargedInfo;
import com.snsclicksystem.main.domain.item.SnsItem;
import com.snsclicksystem.main.domain.member.Member;
import com.snsclicksystem.main.domain.member.SignUp;
import com.snsclicksystem.main.domain.member.dto.MemberInfo;

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
	public Optional<MemberEntity> findEntityByLoginId(String LoginId) {
		return jpaRepository.findEntityByLoginId(LoginId);
	}
	
	@Override
	public Optional<MemberEntity> findEntityById(Long id) {
		return jpaRepository.findById(id);
	}
	


	@Override
	public void save(MemberEntity memberEntity) {
		jpaRepository.save(memberEntity);
	}

	@Override
	public boolean existsByLoginId(String LoginId) {
		return jpaRepository.existsByLoginId(LoginId);
	}
	
	@Override
	public boolean existsByEmail(String email) {
		return jpaRepository.existsByEmail(email);
	}

	@Override
	public Member save(MemberInfo memberInfo) {
		MemberEntity entity = jpaRepository.save(fromMemberInfo(memberInfo));
		return (getMemberFromModel(entity));
	}
	
	private MemberEntity fromMemberInfo(MemberInfo memberInfo){
		return MemberEntity.builder()
					.loginId(memberInfo.getLoginId())
					.password(memberInfo.getPassword())
					.email(memberInfo.getEmail())
					.memberType(memberInfo.getMemberType())
					.memberSex(memberInfo.getMemberSex())
					.corpNum(memberInfo.getCorpNum())
					.totAmount(memberInfo.getTotAmount())
					.build();
	}
	
	 private Member getMemberFromModel(MemberEntity entity){
	        return Member.builder().email(entity.getEmail()).build();
	  }
	

}
