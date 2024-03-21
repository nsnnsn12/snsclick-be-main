package com.snsclicksystem.main.adapter.out.persistence.member.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.snsclicksystem.main.domain.member.Member;

public interface MemberJPARepository extends JpaRepository<MemberEntity, Long> {

	Optional<MemberEntity> findByEmail(String email);

	Optional<MemberEntity> findEntityByLoginId(String loginId); 
	
	Optional<MemberEntity> findByLoginId(String loginId);
	
	boolean existsByEmail(String email);
	
	boolean existsByLoginId(String LoginId);

	
}
