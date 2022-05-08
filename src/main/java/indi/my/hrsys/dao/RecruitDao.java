package indi.my.hrsys.dao;

import java.util.List;

import indi.my.hrsys.entity.Recruit;

public interface RecruitDao {
	List<Recruit> selectAllRecruit();
	boolean addARecruit(Recruit rec);
	boolean deleteARecruit(String pname,String ptype);
	boolean reviseARecruit(Recruit rec);
}
