package com.system.entity;

public class Score {

	private String Sno;
	private String Sname;
	private String Cno;
	private String Cname;
	private String Sscore;
	private String Rescore;

	public Score() {
		super();
	}

	public Score(String sno, String sname, String cno, String cname, String sscore, String rescore) {
		super();
		Sno = sno;
		Sname = sname;
		Cno = cno;
		Cname = cname;
		Sscore = sscore;
		Rescore = rescore;
	}

	public String getSno() {
		return Sno;
	}

	public void setSno(String sno) {
		Sno = sno;
	}

	public String getSname() {
		return Sname;
	}

	public void setSname(String sname) {
		Sname = sname;
	}

	public String getCno() {
		return Cno;
	}

	public void setCno(String cno) {
		Cno = cno;
	}

	public String getCname() {
		return Cname;
	}

	public void setCname(String cname) {
		Cname = cname;
	}

	public String getSscore() {
		return Sscore;
	}

	public void setSscore(String sscore) {
		Sscore = sscore;
	}

	public String getRescore() {
		return Rescore;
	}

	public void setRescore(String rescore) {
		Rescore = rescore;
	}

	@Override
	public String toString() {
		return "Score [Sno=" + Sno + ", Sname=" + Sname + ", Cno=" + Cno + ", Cname=" + Cname + ", Sscore=" + Sscore
				+ ", Rescore=" + Rescore + "]";
	}

}
