package indi.my.hrsys.service.Impl;

import java.util.List;

import indi.my.hrsys.dao.RecruitDao;
import indi.my.hrsys.dao.ResumesDao;
import indi.my.hrsys.dao.impl.RecruitDaoImpl;
import indi.my.hrsys.dao.impl.ResumesDaoImpl;
import indi.my.hrsys.entity.Resumes;
import indi.my.hrsys.service.ResumeService;

public class ResumeServiceImpl implements ResumeService{
	
	private  ResumesDao resumesDao = new ResumesDaoImpl();

	@Override
	public List<Resumes> getAll() {
		// TODO Auto-generated method stub
		return resumesDao.selectAllResumes();
	}

	@Override
	public boolean addAResumes(Resumes res) {
		// TODO Auto-generated method stub
		return resumesDao.addAResumes(res);
	}

	@Override
	public boolean deleteAResumes(String phone) {
		// TODO Auto-generated method stub
		return resumesDao.deleteAResumes(phone);
	}

}
