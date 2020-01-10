package com.leave.attendancemanager.pojo;

import java.io.Serializable;

public class DeleteLeaveReqVo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String ecode;
	public String ename;
	public String from;
	public String to;
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
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	
	

}
