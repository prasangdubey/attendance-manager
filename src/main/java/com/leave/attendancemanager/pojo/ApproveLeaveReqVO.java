package com.leave.attendancemanager.pojo;

import java.io.Serializable;

public class ApproveLeaveReqVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String ecode;
	private String mgrApproval;
	public String getEcode() {
		return ecode;
	}
	public void setEcode(String ecode) {
		this.ecode = ecode;
	}
	public String getMgrApproval() {
		return mgrApproval;
	}
	public void setMgrApproval(String mgrApproval) {
		this.mgrApproval = mgrApproval;
	}
	
	

}