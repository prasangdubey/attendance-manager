package com.leave.attendancemanager.pojo;

import java.io.Serializable;

public class AddEmployeeReqVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String ecode;
	private String ename;
	private String email;
	private String mobileNo;
	public String getEcode() {
		return ecode;
	}
	public void setEcode(String ecode) {
		this.ecode = ecode;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobile_no(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	
}
