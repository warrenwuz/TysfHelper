package org.wuzhe.tysfhelper.pojo;

import java.sql.Timestamp;

/**
 * 回复留言
 * 
 * @author wuzhe
 *
 */
public class ReplayMessage {
	private String rmid;
	private String rmcontent;
	private String mid;// 回复的留言的父留言
	private Timestamp timestamp;// 留言时间
	private String usermark;//留言用户标识 1为自己 2为使用用户
	public ReplayMessage() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ReplayMessage(String rmid, String rmcontent, String mid, Timestamp timestamp, String usermark) {
		super();
		this.rmid = rmid;
		this.rmcontent = rmcontent;
		this.mid = mid;
		this.timestamp = timestamp;
		this.usermark = usermark;
	}
	public String getRmid() {
		return rmid;
	}
	public void setRmid(String rmid) {
		this.rmid = rmid;
	}
	public String getRmcontent() {
		return rmcontent;
	}
	public void setRmcontent(String rmcontent) {
		this.rmcontent = rmcontent;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public Timestamp getTimestamp() {
      /*  String time=timestamp.toString();
        time=time.substring(0,time.lastIndexOf("."));
		return time;*/
		return timestamp;
	}
	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}
	public String getUsermark() {
		return usermark;
	}
	public void setUsermark(String usermark) {
		this.usermark = usermark;
	}
   
}
