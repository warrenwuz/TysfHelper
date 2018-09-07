package org.wuzhe.tysfhelper.pojo;

public class SchoolClass {
	private String cid;
	private String cname;

	public SchoolClass() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SchoolClass(String cid, String cname) {
		super();
		this.cid = cid;
		this.cname = cname;
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	@Override
	public String toString() {
		return "schoolClass [cid=" + cid + ", cname=" + cname + "]";
	}

}
