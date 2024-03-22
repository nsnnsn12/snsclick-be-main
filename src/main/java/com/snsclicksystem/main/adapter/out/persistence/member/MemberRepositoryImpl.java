package com.snsclicksystem.main.adapter.out.persistence.member;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.snsclicksystem.main.application.port.out.persistence.member.MemberRepository;
import com.snsclicksystem.main.domain.member.Member;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepository {
	
	private final MemberJPARepository jpaRepository;
	
	@Override
	public Member save(Member member) {
		MemberEntity entity = jpaRepository.save(fromMember(member));
		return (getMemberFromModel(entity));
	}
	
	@Override
	public Optional<Member> findByLoginId(String LoginId) {
		Optional<MemberEntity> member = jpaRepository.findByLoginId(LoginId);
		return member.map(this::getMemberFromModel);
	}

	@Override
	public boolean existsByLoginId(String LoginId) {
		return jpaRepository.existsByLoginId(LoginId);
	}
	
	@Override
	public boolean existsByEmail(String email) {
		return jpaRepository.existsByEmail(email);
	}
	
	private MemberEntity fromMember(Member member){
		return MemberEntity.builder()
					.loginId(member.getLoginId())
					.password(member.getPassword())
					.email(member.getEmail())
					.memberType(member.getMemberType())
					.totalAmount(member.getTotalAmount())
					.build();
	}
	
	 private Member getMemberFromModel(MemberEntity entity){
	        return Member.builder()
	        			.loginId(entity.getLoginId())
	        			.email(entity.getEmail())
	        			.password(entity.getPassword())
	        			.memberType(entity.getMemberType())
	        			.totalAmount(entity.getTotalAmount())
	        			.build();
	  }

}
