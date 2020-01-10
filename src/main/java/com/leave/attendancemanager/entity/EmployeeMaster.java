package com.leave.attendancemanager.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="EMPLOYEE_MASTER")
public class EmployeeMaster {

	@Id 
	@Column(name="ECODE")
	private String ecode;
	
	@Column(name="ENAME")
	private String ename;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name = "MOBILE_NO")
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

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	@Override
	public String toString() {
		return "EmployeeMaster [ecode=" + ecode + ", ename=" + ename + ", email=" + email + ", mobileNo=" + mobileNo
				+ "]";
	}
	
	
	
}
