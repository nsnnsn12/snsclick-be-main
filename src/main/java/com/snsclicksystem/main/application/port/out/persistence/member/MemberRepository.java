package com.snsclicksystem.main.application.port.out.persistence.member;


import java.util.Optional;

import com.snsclicksystem.main.domain.member.Member;


public interface MemberRepository {

	public Member save(Member member);
	
	public Optional<Member> findByLoginId(String LoginId);
	
	public boolean existsByLoginId(String LoginId);

	public boolean existsByEmail(String email);

	

	

	

}
