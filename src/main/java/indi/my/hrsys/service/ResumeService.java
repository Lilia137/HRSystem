package indi.my.hrsys.service;

import java.util.List;

import indi.my.hrsys.entity.Resumes;

public interface ResumeService {
	List<Resumes> getAll();
	boolean addAResumes(Resumes res);
	boolean deleteAResumes(String phone);
}
