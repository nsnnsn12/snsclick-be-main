package com.snsclicksystem.main.application.port.out.persistence.member;


import java.util.Optional;

import com.snsclicksystem.main.domain.member.Member;


public interface MemberRepository {

	public Member save(Member member);
	
	public Optional<Member> findByUsername(String username);
	
	public boolean existsByUsername(String username);

	public boolean existsByEmail(String email);

	


	

	

	

}
