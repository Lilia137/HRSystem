package indi.my.hrsys.entity;

public class Resumes {
	private String wholename;
	private String sex;
	private String age;
	private String workyear;
	private String edulevel;
	private String phone;
	private String aid;		//相应的招聘信息号码

	public String getWholename() {
		return wholename;
	}
	public void setWholename(String wholename) {
		this.wholename = wholename;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getWorkyear() {
		return workyear;
	}
	public void setWorkyear(String workyear) {
		this.workyear = workyear;
	}
	public String getEdulevel() {
		return edulevel;
	}
	public void setEdulevel(String edulevel) {
		this.edulevel = edulevel;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getAid() {
		return aid;
	}
	public void setAid(String aid) {
		this.aid = aid;
	}
	public Resumes(String wholename, String sex, String age, String workyear, String edulevel, String phone) {
		super();
		this.wholename = wholename;
		this.sex = sex;
		this.age = age;
		this.workyear = workyear;
		this.edulevel = edulevel;
		this.phone = phone;
	}
	
	public Resumes(String wholename, String sex, String age, String workyear, String edulevel, String phone,
			String aid) {
		super();
		this.wholename = wholename;
		this.sex = sex;
		this.age = age;
		this.workyear = workyear;
		this.edulevel = edulevel;
		this.phone = phone;
		this.aid = aid;
	}
	@Override
	public String toString() {
		return "resumes [wholename=" + wholename + ", sex=" + sex + ", age=" + age + ", workyear=" + workyear
				+ ", edulevel=" + edulevel + ", phone=" + phone + "]";
	}
	
}
