package com.snsclicksystem.main.application.port.out.persistence.member;


import java.util.Optional;

import com.snsclicksystem.main.adapter.out.persistence.member.repository.MemberEntity;
import com.snsclicksystem.main.domain.member.Member;
import com.snsclicksystem.main.domain.member.SignUp;
import com.snsclicksystem.main.domain.member.dto.MemberInfo;

import lombok.NonNull;

public interface MemberRepository {

	public int findTotAmountById(Long id);

	public Optional<Member> findById(Long id);
	
	public Optional<MemberEntity> findEntityByLoginId(String loginId);

	public Optional<MemberEntity> findEntityById(Long id);

	public void save(MemberEntity memberEntity);

	public Member save(MemberInfo memberInfo);
	
	public boolean existsByLoginId(String LoginId);

	public boolean existsByEmail(String email);

	

	

}
