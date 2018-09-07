package org.wuzhe.tysfhelper.pojo;

import java.sql.Timestamp;

public class Message {
	private String mid;// 留言主键
	private String content;// 留言内容
	private String openid;// 留言学生
	private String tid;// 给留言的老师id
	private Timestamp timestamp;// 留言时间
	private String isread;//是否已经阅读 1为阅读 0为未阅读
	private String tname;//为了在微信端显示留言可以显示老师的姓名
	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Message(String mid, String content, String openid, String tid, Timestamp timestamp,String isread) {
		super();
		this.mid = mid;
		this.content = content;
		this.openid = openid;
		this.tid = tid;
		this.timestamp = timestamp;
		this.isread=isread;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getContent() {
		return content;
	}

	public void setContentt(String content) {
		this.content = content;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getTid() {
		return tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}
    
	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public Timestamp getTimestamp() {
		/*String time = timestamp.toString();
		time = time.substring(0, time.lastIndexOf("."));
		return time;*/
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}
    
	public String getIsread() {
		return isread;
	}

	public void setIsread(String isread) {
		this.isread = isread;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Message [mid=" + mid + ", content=" + content + ", openid=" + openid + ", tid=" + tid + ", timestamp="
				+ timestamp + ", isread=" + isread + "]";
	}



}
