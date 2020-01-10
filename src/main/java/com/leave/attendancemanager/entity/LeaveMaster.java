package com.leave.attendancemanager.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="LEAVE_MASTER")
public class LeaveMaster {
	@Id
	@Column(name="ECODE")
	private String ecode;
	@Column(name="FROM_DT")
	private String from;
	@Column(name="TO_DT")
	private String to;
	@Column(name="MGR_APPROVAL")
	private String mgrApproval;
	public String getEcode() {
		return ecode;
	}
	public void setEcode(String ecode) {
		this.ecode = ecode;
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
	public String getMgrApproval() {
		return mgrApproval;
	}
	public void setMgrApproval(String mgrApproval) {
		this.mgrApproval = mgrApproval;
	}
	@Override
	public String toString() {
		return "LeaveMaster [ecode=" + ecode + ", from=" + from + ", to=" + to + ", mgrApproval=" + mgrApproval + "]";
	}
	
}
