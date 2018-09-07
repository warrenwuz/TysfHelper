package org.wuzhe.tysfhelper.pojo;

public class TemplateData {
	private TemplateContent first;
	private TemplateContent keynote1;
	private TemplateContent keynote2;
	private TemplateContent keynote3;
	private TemplateContent  remark;
	public TemplateData() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TemplateData(TemplateContent first, TemplateContent keynote1,TemplateContent keynote2) {
		super();
		this.first = first;
		this.keynote1 = keynote1;
		this.keynote2=keynote2;
	}
	
	public TemplateData(TemplateContent first, TemplateContent keynote1, TemplateContent keynote2,
			TemplateContent keynote3) {
		super();
		this.first = first;
		this.keynote1 = keynote1;
		this.keynote2 = keynote2;
		this.keynote3 = keynote3;
	}
	
	public TemplateData(TemplateContent first, TemplateContent keynote1, TemplateContent keynote2,
			TemplateContent keynote3, TemplateContent remark) {
		super();
		this.first = first;
		this.keynote1 = keynote1;
		this.keynote2 = keynote2;
		this.keynote3 = keynote3;
		this.remark = remark;
	}
	public TemplateContent getFirst() {
		return first;
	}
	public void setFirst(TemplateContent first) {
		this.first = first;
	}
	public TemplateContent getKeynote1() {
		return keynote1;
	}
	public void setKeynote1(TemplateContent keynote1) {
		this.keynote1 = keynote1;
	}
	
	public TemplateContent getKeynote2() {
		return keynote2;
	}
	public void setKeynote2(TemplateContent keynote2) {
		this.keynote2 = keynote2;
	}
	
	public TemplateContent getKeynote3() {
		return keynote3;
	}
	public void setKeynote3(TemplateContent keynote3) {
		this.keynote3 = keynote3;
	}
	public TemplateContent getRemark() {
		return remark;
	}
	public void setRemark(TemplateContent remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "TemplateData [first=" + first + ", keynote1=" + keynote1 + "]";
	}
	
	
	
}
