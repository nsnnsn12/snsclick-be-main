package com.snsclicksystem.main.domain.member.enums;

public enum MemberType {

	 NORMAL, CORP, ADMIN, GUEST;
	 
	 public String getGrantedAuthority() {
	        return "ROLE_" + name();
	    }
	 
	 public String getMemberType() {
		 return name();
	 }
}
