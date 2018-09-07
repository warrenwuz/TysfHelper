package org.wuzhe.tysfhelper.pojo;

/**
 * 互动填空题
 * 
 * @author wuzhe
 *
 */
public class TianKongQuestion {
	private String tqid;
	private String tqcontent;
	private String tqcorrectanswer;

	public TianKongQuestion() {
		super();
	}

	public TianKongQuestion(String tqid, String tqcontent, String tqcorrectanswer) {
		super();
		this.tqid = tqid;
		this.tqcontent = tqcontent;
		this.tqcorrectanswer = tqcorrectanswer;
	}

	public String getTqid() {
		return tqid;
	}

	public void setTqid(String tqid) {
		this.tqid = tqid;
	}

	public String getTqcontent() {
		return tqcontent;
	}

	public void setTqcontent(String tqcontent) {
		this.tqcontent = tqcontent;
	}

	public String getTqcorrectanswer() {
		return tqcorrectanswer;
	}

	public void setTqcorrectanswer(String tqcorrectanswer) {
		this.tqcorrectanswer = tqcorrectanswer;
	}

	@Override
	public String toString() {
		return "TianKongQuestion [tqid=" + tqid + ", tqcontent=" + tqcontent + ", tqcorrectanswer=" + tqcorrectanswer
				+ "]";
	}

	

}
