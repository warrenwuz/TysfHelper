package org.wuzhe.tysfhelper.pojo;

/**
 * 作业通知映射类
 * 
 * @author wuzhe
 *
 */
public class HomeworkNotice {
	private String hid;
	private String cid;

	public HomeworkNotice(String hid, String cid) {
		super();
		this.hid = hid;
		this.cid = cid;
	}

	@Override
	public String toString() {
		return "HomeworkNotice [hid=" + hid + ", cid=" + cid + "]";
	}

	public String getHid() {
		return hid;
	}

	public void setHid(String hid) {
		this.hid = hid;
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

}
