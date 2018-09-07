package org.wuzhe.tysfhelper.pojo;

public class Course {
	private String ckey;
	private String cId;
	private String cname;

	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Course(String key, String cId, String name) {
		super();
		this.ckey = key;
		this.cId = cId;
		this.cname = name;
	}

	public String getKey() {
		return ckey;
	}

	public void setKey(String key) {
		this.ckey = key;
	}

	public String getcId() {
		return cId;
	}

	public void setcId(String cId) {
		this.cId = cId;
	}

	public String getName() {
		return cname;
	}

	public void setName(String name) {
		this.cname = name;
	}

	@Override
	public String toString() {
		return "Course [ckey=" + ckey + ", cId=" + cId + ", cname=" + cname + "]";
	}
   
}
