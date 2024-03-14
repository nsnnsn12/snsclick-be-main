package com.snsclicksystem.main.application.port.out.persistence.member;


import java.util.Optional;

import com.snsclicksystem.main.adapter.out.persistence.member.MemberEntity;
import com.snsclicksystem.main.domain.member.Member;

import lombok.NonNull;

public interface MemberRepository {

	public int findTotAmountById(Long id);

	public Optional<Member> findById(Long id);

	public Optional<MemberEntity> findEntityById(Long id);

	public void save(MemberEntity memberEntity);

}
