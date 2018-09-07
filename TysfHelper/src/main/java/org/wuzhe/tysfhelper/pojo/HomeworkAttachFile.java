package org.wuzhe.tysfhelper.pojo;

/**
 * 作业和附件的映射类
 * 
 * @author wuzhe
 *
 */
public class HomeworkAttachFile {
	private String afid;
	private String hid;

	public HomeworkAttachFile() {
		super();
	}

	public HomeworkAttachFile(String afid, String hid) {
		super();
		this.afid = afid;
		this.hid = hid;
	}

	public String getAfid() {
		return afid;
	}

	public void setAfid(String afid) {
		this.afid = afid;
	}

	public String getHid() {
		return hid;
	}

	public void setHid(String hid) {
		this.hid = hid;
	}

	@Override
	public String toString() {
		return "HomeworkAttachFile [afid=" + afid + ", hid=" + hid + "]";
	}

}
