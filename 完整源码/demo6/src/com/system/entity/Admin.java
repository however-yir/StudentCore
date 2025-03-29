package com.system.entity;

public class Admin {

	private int aId;
	private String aName;
	private String aPwd;

	public Admin() {
		super();
	}

	public Admin(int aId, String aName, String aPwd) {
		super();
		this.aId = aId;
		this.aName = aName;
		this.aPwd = aPwd;
	}

	public int getaId() {
		return aId;
	}

	public void setaId(int aId) {
		this.aId = aId;
	}

	public String getaName() {
		return aName;
	}

	public void setaName(String aName) {
		this.aName = aName;
	}

	public String getaPwd() {
		return aPwd;
	}

	public void setaPwd(String aPwd) {
		this.aPwd = aPwd;
	}

	@Override
	public String toString() {
		return "Admin [aId=" + aId + ", aName=" + aName + ", aPwd=" + aPwd + "]";
	}

}
