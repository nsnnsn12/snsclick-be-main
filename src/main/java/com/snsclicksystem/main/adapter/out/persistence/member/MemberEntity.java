package com.snsclicksystem.main.adapter.out.persistence.member;

import com.snsclicksystem.main.adapter.out.persistence.common.BaseTimeEntity;
import com.snsclicksystem.main.domain.member.enums.MemberType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity(name = "member")
@NoArgsConstructor(access = AccessLevel.PROTECTED)	//생성자 protected로 생성해서 생성자 사용불가하게 만듬
public class MemberEntity extends BaseTimeEntity{
	
	@Builder
	private MemberEntity(String username, String password, String email, Long totalAmount, MemberType memberType) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.totalAmount = totalAmount;
		this.memberType = memberType;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "member_id")
	private Long id;
	
	private String username;
	
	private String password;
	
	private String email;
	
	private Long totalAmount; 
	
	@Enumerated(EnumType.STRING)
	private MemberType memberType;

}
