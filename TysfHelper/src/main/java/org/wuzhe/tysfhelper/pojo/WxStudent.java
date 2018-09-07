package org.wuzhe.tysfhelper.pojo;

/**
 * 微信用户绑定类
 * 
 * @author wuzhe 以微信openid唯一标识作为主键
 *
 */
public class WxStudent {
	private String openid;
	private String stuId;// 学号
	private String password;// 保存用户MD5加密的密码
    private String cid;//班级号
	public WxStudent() {
		super();
		// TODO Auto-generated constructor stub
	}

	public WxStudent(String openid, String stuId, String password) {
		this.openid = openid;
		this.stuId = stuId;
		this.password = password;
	}

	public WxStudent(String openid, String stuId, String password, String cid) {
		super();
		this.openid = openid;
		this.stuId = stuId;
		this.password = password;
		this.cid=cid;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getStuId() {
		return stuId;
	}

	public void setStuId(String stuId) {
		this.stuId = stuId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCid() { return cid; }

	public void setCid(String cid) { this.cid = cid; }
}
