package com.system.entity;

public class Course {

	private String cnum;
	private String cno;
	private String cname;
	private String ccredit;
	private String ctime;

	public Course() {
		super();
	}

	public Course(String cnum, String cno, String cname, String ccredit, String ctime) {
		super();
		this.cnum = cnum;
		this.cno = cno;
		this.cname = cname;
		this.ccredit = ccredit;
		this.ctime = ctime;
	}

	public String getCnum() {
		return cnum;
	}

	public void setCnum(String cnum) {
		this.cnum = cnum;
	}

	public String getCno() {
		return cno;
	}

	public void setCno(String cno) {
		this.cno = cno;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getCcredit() {
		return ccredit;
	}

	public void setCcredit(String ccredit) {
		this.ccredit = ccredit;
	}

	public String getCtime() {
		return ctime;
	}

	public void setCtime(String ctime) {
		this.ctime = ctime;
	}

	@Override
	public String toString() {
		return "Course [cnum=" + cnum + ", cno=" + cno + ", cname=" + cname + ", ccredit=" + ccredit + ", ctime="
				+ ctime + "]";
	}

}
