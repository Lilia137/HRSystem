package indi.my.hrsys.service.Impl;

import java.util.List;

import indi.my.hrsys.dao.EmpDao;
import indi.my.hrsys.dao.impl.EmpDaoImpl;
import indi.my.hrsys.entity.Employee;
import indi.my.hrsys.service.EmpService;

public class EmpServiceImpl implements EmpService{
	
	private EmpDao empDao = new EmpDaoImpl();
	
	@Override
	public List<Employee> getAll() {
		return empDao.selectAllEmp();
	}

	@Override
	public boolean addEmp(Employee emp) {
		return empDao.addAEmp(emp);
	}

	@Override
	public boolean deleteEmp(String eid, String ename) {
		return empDao.deleteAEmp(eid, ename);
	}

	@Override
	public boolean reviseEmp(Employee emp) {
		return empDao.reviseAEmp(emp);
	}
		
	
}
