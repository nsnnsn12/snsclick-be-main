package com.snsclicksystem.main.application.port.out.persistence.member;


import java.util.Optional;

import com.snsclicksystem.main.adapter.out.persistence.member.MemberEntity;
import com.snsclicksystem.main.domain.member.MemberInfo;

import lombok.NonNull;

public interface MemberRepository {

	public int findTotAmountById(Long id);

	public Optional<MemberInfo> findById(Long id);
	
	public Optional<MemberEntity> findEntityByLoginId(String loginId);

	public Optional<MemberEntity> findEntityById(Long id);

	public void save(MemberEntity memberEntity);
	
	public boolean existsByLoginId(String LoginId);

	

	

}
