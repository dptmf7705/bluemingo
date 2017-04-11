package com.bluemingo.bluemingo.domain;

import org.springframework.security.core.GrantedAuthority;

public class RoleVO implements GrantedAuthority{
	private static final long serialVersionUID = 1L;
	
	private String role_name;
	
	public RoleVO(String rolename){
		this.role_name = rolename;
	}
	
	@Override
	public String getAuthority() {
		return this.role_name;
	}

	public String getRole_name() {
		return role_name;
	}

	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}
	
	public String toString(){
		return ""+role_name;
	}
}