package org.wuzhe.tysfhelper.pojo;

import java.util.List;

public class Teacher {
	private String tid;
	private String tpassword;
	private String tname;
    private List<SchoolClass> schoolCLass;
	public Teacher() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Teacher(String tid, String tpassword) {
		super();
		this.tid = tid;
		this.tpassword = tpassword;
	}
	public Teacher(String tid, String tpassword, String tname) {
		super();
		this.tid = tid;
		this.tpassword = tpassword;
		this.tname = tname;
	}
    
	public String getTid() {
		return tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	public String getTpassword() {
		return tpassword;
	}

	public void setTpassword(String tpassword) {
		this.tpassword = tpassword;
	}
    
	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}
    
	public List<SchoolClass> getSchoolCLass() {
		return schoolCLass;
	}

	public void setSchoolCLass(List<SchoolClass> schoolCLass) {
		this.schoolCLass = schoolCLass;
	}

	@Override
	public String toString() {
		return "Teacher [tid=" + tid + ", tpassword=" + tpassword + "]";
	}

}
