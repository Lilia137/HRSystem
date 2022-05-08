package indi.my.hrsys.dao;

import java.util.List;

import indi.my.hrsys.entity.Resumes;


public interface ResumesDao {
	List<Resumes> selectAllResumes();
	boolean addAResumes(Resumes res);
	boolean deleteAResumes(String phone);
}
