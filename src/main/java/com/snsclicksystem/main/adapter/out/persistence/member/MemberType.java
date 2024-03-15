package com.snsclicksystem.main.adapter.out.persistence.member;

public enum MemberType {

	 NORMAL, CORP, ADMIN, GUEST;
	 
	 public String getGrantedAuthority() {
	        return "ROLE_" + name();
	    }
}
