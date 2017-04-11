package com.bluemingo.bluemingo.domain;


public class LoginVO {
	private String loginId;
	private String loginPassword;

	@Override
	public String toString() {
		return "LoginVO [loginId=" + loginId + ", loginPassword=" + loginPassword + "]";
	}
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getLoginPassword() {
		return loginPassword;
	}
	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}
}
