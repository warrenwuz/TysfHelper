package org.wuzhe.tysfhelper.pojo;

public class ClassAdmin {
	private String caid;
	private String capassword;

	public ClassAdmin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ClassAdmin(String caid, String capassword) {
		super();
		this.caid = caid;
		this.capassword = capassword;
	}

	public String getCaid() {
		return caid;
	}

	public void setCaid(String caid) {
		this.caid = caid;
	}

	public String getCapassword() {
		return capassword;
	}

	public void setCapassword(String capassword) {
		this.capassword = capassword;
	}

	@Override
	public String toString() {
		return "ClassAdmin [caid=" + caid + ", capassword=" + capassword + "]";
	}

}
