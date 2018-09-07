package org.wuzhe.tysfhelper.pojo;

import java.sql.Timestamp;

/**
 * 附件(作业,通知)
 * 
 * @author wuzhe
 *
 */
public class AttachFile {
	private String afid;// 附件的唯一标识
	private String afName;// 附件名字
	private Timestamp timestamp;// 附件上传时间
	public AttachFile() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AttachFile(String afid, String afName, Timestamp timestamp) {
		super();
		this.afid = afid;
		this.afName = afName;
		this.timestamp = timestamp;
	}

	public String getAfid() {
		return afid;
	}

	public void setAfid(String afid) {
		this.afid = afid;
	}

	public String getAfName() {
		return afName;
	}

	public void setAfName(String afName) {
		this.afName = afName;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "AttachFile [afid=" + afid + ", afName=" + afName + ", timestamp=" + timestamp + "]";
	}

	
}
