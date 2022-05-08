package indi.my.hrsys.entity;

public class Userinfo {
	private String userid;
	private String userpsw;
	private String nickname;
	private String headpic;
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUserpsw() {
		return userpsw;
	}
	public void setUserpsw(String userpsw) {
		this.userpsw = userpsw;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getHeadpic() {
		return headpic;
	}
	public void setHeadpic(String headpic) {
		this.headpic = headpic;
	}

	public Userinfo(){}

	public Userinfo(String userid, String userpsw, String nickname, String headpic) {
		super();
		this.userid = userid;
		this.userpsw = userpsw;
		this.nickname = nickname;
		this.headpic = headpic;
	}
	
	
	public Userinfo(String userid, String userpsw) {
		super();
		this.userid = userid;
		this.userpsw = userpsw;
	}
	@Override
	public String toString() {
		return "Userinfo [userid=" + userid + ", userpsw=" + userpsw + ", nickname=" + nickname + ", headpic=" + headpic
				+ "]";
	}
	
	
	
}
