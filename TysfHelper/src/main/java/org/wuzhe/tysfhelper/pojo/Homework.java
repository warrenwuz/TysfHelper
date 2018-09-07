package org.wuzhe.tysfhelper.pojo;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

/**
 * 作业通知实体类
 * 
 * @author wuzhe
 *
 */
public class Homework {
	private String hid;//作业的唯一标识
	private String htitle;// 作业标题
	private String hcontent;// 作业内容
	private Timestamp timestamp;// 作业的时间戳
	private String tid;//老师ID外键
	private List<SchoolClass> scList;//通知的班级
	private Date sumbitdate;//作业提交日期
	public Homework() {
		super();
	}

	public Homework(String htitle, String hcontent, Timestamp timestamp,String hid,String tid,Date sumbitdate) {
		super();
		this.htitle = htitle;
		this.hcontent = hcontent;
		this.timestamp = timestamp;
		this.hid=hid;
		this.tid=tid;
		this.sumbitdate=sumbitdate;
	}

	public String getHtitle() {
		return htitle;
	}

	public void setHtitle(String htitle) {
		this.htitle = htitle;
	}

	public String getHcontent() {
		return hcontent;
	}

	public void setHcontent(String hcontent) {
		this.hcontent = hcontent;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public String getHid() {
		return hid;
	}

	public void setHid(String hid) {
		this.hid = hid;
	}
   
	public String getTid() {
		return tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}
    
	public List<SchoolClass> getScList() {
		return scList;
	}

	public void setScList(List<SchoolClass> scList) {
		this.scList = scList;
	}
    
	public Date getDate() {
		return sumbitdate;
	}

	public void setDate(Date sumbitdate) {
		this.sumbitdate = sumbitdate;
	}

	@Override
	public String toString() {
		return "Homework [hid=" + hid + ", htitle=" + htitle + ", hcontent=" + hcontent + ", timestamp=" + timestamp
				+ ", tid=" + tid + "]";
	}


   
}
