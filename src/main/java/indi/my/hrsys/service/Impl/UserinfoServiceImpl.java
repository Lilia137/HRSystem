package indi.my.hrsys.service.Impl;

import indi.my.hrsys.dao.UserinfoDao;
import indi.my.hrsys.dao.impl.UserinfoDaoImpl;
import indi.my.hrsys.entity.Userinfo;
import indi.my.hrsys.service.UserinfoService;

public class UserinfoServiceImpl implements UserinfoService{
	private UserinfoDao userinfoDao = new UserinfoDaoImpl();
	
	@Override
	public Userinfo login(String userid, String userpsw) {
		return userinfoDao.selectByUseridAndUserpsw(new Userinfo(userid,userpsw));
	}
	
	@Override
	public boolean register(String userid,String userpsw,String nickname,String headpic) {
		if(userid==null ||userid.length()<1) {
			return false;
		}
		if(userpsw==null ||userpsw.length()<1) {
			return false;
		}
		return userinfoDao.putInRegisterData(new Userinfo(userid, userpsw, nickname,headpic));
		
	}
}
