package com.snsclicksystem.main.adapter.out.persistence.member;

import com.snsclicksystem.main.adapter.out.persistence.common.BaseTimeEntity;
import com.snsclicksystem.main.domain.member.dto.MemberInfo;
import com.snsclicksystem.main.domain.member.enums.MemberType;

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
import lombok.Setter;

@Entity(name = "member")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)	//생성자 protected로 생성해서 생성자 사용불가하게 만듬
public class MemberEntity extends BaseTimeEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "member_id")
	private Long id;
	
	private String loginId;
	
	private String password;
	
	private String email;
	
	private Long totalAmount; 
	
	@Enumerated(EnumType.STRING)
	private MemberType memberType;
	
	// @Builder사용 시, 생성자가 없어서 optional<MemberEntity> 로 데이터 찾으면 에러 발생..
	// memberEntity를 어디서 생성할지 추후 논의 후 결정해야 할 듯
	public static MemberEntity createMemberEntity(MemberInfo memberInfo){
		MemberEntity memberEntity = new MemberEntity();
		memberEntity.setLoginId(memberInfo.getLoginId()); 
		memberEntity.setPassword(memberInfo.getPassword());
		memberEntity.setEmail(memberInfo.getEmail());
		memberEntity.setMemberType(memberInfo.getMemberType());
		memberEntity.setTotalAmount(memberInfo.getTotalAmount());
		return memberEntity;
	}
}
