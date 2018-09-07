package org.wuzhe.tysfhelper.pojo;

/**
 * 老师-班级映射类
 * 
 * @author wuzhe
 *
 */
public class Teaching {
	private String tid;// 教师主键
	private String cid;// 班级主键

	public Teaching() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Teaching(String tid, String cid) {
		super();
		this.tid = tid;
		this.cid = cid;
	}

	public String getTid() {
		return tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	@Override
	public String toString() {
		return "Teaching [tid=" + tid + ", cid=" + cid + "]";
	}

}
