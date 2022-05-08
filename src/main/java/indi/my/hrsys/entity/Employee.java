package indi.my.hrsys.entity;

public class Employee {
	private String eid;
	private String ename;
	private String dept;
	private String position;
	private String phone;
	private String state;
	
	public String getEid() {
		return eid;
	}
	public void setEid(String eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	public Employee(String eid, String ename, String dept, String position, String phone, String state) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.dept = dept;
		this.position = position;
		this.phone = phone;
		this.state = state;
	}
	
	
	public Employee(String eid, String ename) {
		super();
		this.eid = eid;
		this.ename = ename;
	}
	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", dept=" + dept + ", position=" + position + ", phone="
				+ phone + ", state=" + state + "]";
	}
	
	
}
