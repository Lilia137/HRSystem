package indi.my.hrsys.service;

import indi.my.hrsys.entity.Userinfo;

public interface UserinfoService {
	Userinfo login(String userid,String userpsw);
	boolean register(String userid,String userpsw,String nickname,String headpic);

}
