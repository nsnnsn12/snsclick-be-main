package com.snsclicksystem.main.adapter.out.persistence.member;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.snsclicksystem.main.domain.member.Member;

public interface MemberJPARepository extends JpaRepository<MemberEntity, Long> {

	Optional<MemberEntity> findByEmail(String email);
	
	Optional<MemberEntity> findByUsername(String username);
	
	boolean existsByEmail(String email);
	
	boolean existsByUsername(String username);

	


	
}
