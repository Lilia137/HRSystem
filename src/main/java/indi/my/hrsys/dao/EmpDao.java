package indi.my.hrsys.dao;

import java.util.List;

import indi.my.hrsys.entity.Employee;

public interface EmpDao {
	List<Employee> selectAllEmp();
	Employee selectByEidAndEname(Employee emp);
	boolean addAEmp(Employee emp);
	boolean deleteAEmp(String eid,String ename);
	boolean reviseAEmp(Employee emp);
}
