package indi.my.hrsys.service;

import java.util.List;

import indi.my.hrsys.entity.Recruit;

public interface RecruitService {
	List<Recruit> getAll();
	boolean addRecruit(Recruit rec);
	boolean deleteRecruit(String pname,String ptype);
	boolean reviseRecruit(Recruit rec);
}
