package com.bluemingo.bluemingo.domain;


public class LoginVO {
	private String loginId;
	private String loginPassword;
	private String messege;

	public String getMessege() {
		return messege;
	}
	public void setMessege(String messege) {
		this.messege = messege;
	}
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
