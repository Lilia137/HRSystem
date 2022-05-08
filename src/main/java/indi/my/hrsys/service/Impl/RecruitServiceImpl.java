package indi.my.hrsys.service.Impl;

import java.util.List;

import indi.my.hrsys.dao.RecruitDao;
import indi.my.hrsys.dao.impl.RecruitDaoImpl;
import indi.my.hrsys.entity.Recruit;
import indi.my.hrsys.service.RecruitService;

public class RecruitServiceImpl implements RecruitService{
	
	private  RecruitDao recruitDao = new RecruitDaoImpl();

	@Override
	public List<Recruit> getAll() {
		// TODO Auto-generated method stub
		return recruitDao.selectAllRecruit();
	}

	@Override
	public boolean addRecruit(Recruit rec) {
		// TODO Auto-generated method stub
		return recruitDao.addARecruit(rec);
	}

	@Override
	public boolean deleteRecruit(String pname, String ptype) {
		// TODO Auto-generated method stub
		return recruitDao.deleteARecruit(pname, ptype);
	}

	@Override
	public boolean reviseRecruit(Recruit rec) {
		// TODO Auto-generated method stub
		return recruitDao.reviseARecruit(rec);
	}

}
