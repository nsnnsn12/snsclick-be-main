package com.snsclicksystem.main.adapter.out.persistence.member;

import com.snsclicksystem.main.adapter.out.persistence.common.BaseTimeEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "member")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)	//생성자 protected로 생성해서 생성자 사용불가하게 만듬
public class MemberEntity extends BaseTimeEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "member_id")
	private Long id;
	
	private String loginId;
	
	private String password;
	
	private Long totalAmount; 
	
	private String email;
	
	@Enumerated(EnumType.STRING)
	private MemberType memberType;

	public MemberEntity(String email) {
		this.email = email;
	}
}
