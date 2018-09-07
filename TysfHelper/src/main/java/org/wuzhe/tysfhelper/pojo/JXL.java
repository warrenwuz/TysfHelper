package org.wuzhe.tysfhelper.pojo;

/**
 * 教学楼实体类
 * 
 * @author wuzhe
 *
 */
public class JXL {
	private String jid;// 教学楼id
	private String jname;// 教学楼姓名

	public JXL() {
		super();
	}

	public JXL(String jid, String jname) {
		super();
		this.jid = jid;
		this.jname = jname;
	}

	public String getId() {
		return jid;
	}

	public String getName() {
		return jname;
	}

	@Override
	public String toString() {
		return "JXL [jid=" + jid + ", jname=" + jname + "]";
	}
}
