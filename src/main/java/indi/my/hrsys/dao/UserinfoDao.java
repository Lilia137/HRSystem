package indi.my.hrsys.dao;

import java.util.List;

import indi.my.hrsys.entity.Userinfo;

public interface UserinfoDao {
//	List<Userinfo> selectAll();
	Userinfo selectByUseridAndUserpsw(Userinfo userinfo);
	boolean putInRegisterData(Userinfo user);
}
