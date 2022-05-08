package indi.my.hrsys.entity;

public class Recruit {

	private String pname;
	private String ptype;
	private String worktime;
	private String salary;
	private String neednum;
	private String deadline;
	
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPtype() {
		return ptype;
	}
	public void setPtype(String ptype) {
		this.ptype = ptype;
	}
	public String getWorktime() {
		return worktime;
	}
	public void setWorktime(String worktime) {
		this.worktime = worktime;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public String getNeednum() {
		return neednum;
	}
	public void setNeednum(String neednum) {
		this.neednum = neednum;
	}
	public String getDeadline() {
		return deadline;
	}
	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}
	
	public Recruit(String pname, String ptype, String worktime, String salary, String neednum, String deadline) {
		super();
		this.pname = pname;
		this.ptype = ptype;
		this.worktime = worktime;
		this.salary = salary;
		this.neednum = neednum;
		this.deadline = deadline;
	}
	
	@Override
	public String toString() {
		return "recruit [pname=" + pname + ", ptype=" + ptype + ", worktime=" + worktime + ", salary=" + salary
				+ ", neednum=" + neednum + ", deadline=" + deadline + "]";
	}
	
	

}
