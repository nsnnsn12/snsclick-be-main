package com.snsclicksystem.main.adapter.out.persistence.member;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberJPARepository extends JpaRepository<MemberEntity, Long> {

	Optional<MemberEntity> findByEmail(String email);

	Optional<MemberEntity> findEntityByLoginId(String loginId); 
	
	boolean existsByLoginId(String LoginId);
}
