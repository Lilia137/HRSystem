package indi.my.hrsys.service;

import java.util.List;

import indi.my.hrsys.entity.Employee;

public interface EmpService {
	List<Employee> getAll();
	boolean addEmp(Employee emp);
	boolean deleteEmp(String eid,String ename);
	boolean reviseEmp(Employee emp);
}
