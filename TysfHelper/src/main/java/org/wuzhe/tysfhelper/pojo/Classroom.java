package org.wuzhe.tysfhelper.pojo;

public class Classroom {
	private String rid;
	private String rname;
	private String jid;// 教学楼Id

	public Classroom() {
		super();
	}

	public Classroom(String rid, String rname, String jid) {
		super();
		this.rid = rid;
		this.rname = rname;
		this.jid = jid;
	}

	public String getRid() {
		return rid;
	}

	public void setRid(String rid) {
		this.rid = rid;
	}

	public String getName() {
		return rname;
	}

	public void setName(String name) {
		this.rname = name;
	}

	public String getJid() {
		return jid;
	}

	public void setJid(String jid) {
		this.jid = jid;
	}

	@Override
	public String toString() {
		return "Classroom [rid=" + rid + ", rname=" + rname + ", jid=" + jid + "]";
	}

}
