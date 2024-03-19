package com.snsclicksystem.main.adapter.out.persistence.member.repository;

import com.snsclicksystem.main.adapter.out.persistence.common.BaseTimeEntity;
import com.snsclicksystem.main.domain.member.enums.MemberSex;
import com.snsclicksystem.main.domain.member.enums.MemberType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;

@Entity(name = "member")
@Getter
@Builder
//@NoArgsConstructor(access = AccessLevel.PROTECTED)	//생성자 protected로 생성해서 생성자 사용불가하게 만듬
public class MemberEntity extends BaseTimeEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "member_id")
	private Long id;
	
	private String loginId;
	
	private String password;
	
	private String email;
	
	private Long totAmount; 
	
	private Long corpNum;
	
	@Enumerated(EnumType.STRING)
	private MemberSex memberSex;
	
	@Enumerated(EnumType.STRING)
	private MemberType memberType;

	
}
