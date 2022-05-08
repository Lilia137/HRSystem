package indi.my.hrsys.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import indi.my.hrsys.dao.EmpDao;
import indi.my.hrsys.db.BaseDao;
import indi.my.hrsys.entity.Employee;
import indi.my.hrsys.entity.Userinfo;

public class EmpDaoImpl implements EmpDao {

	private BaseDao baseDao = new BaseDao();

	@Override
	public List<Employee> selectAllEmp() {
		String sql = "select * from employee";
		List<Employee> list = new ArrayList<Employee>();
		baseDao.open();
		ResultSet rs = baseDao.execDQL(sql);
		try {
			while (rs.next()) {
				Employee emp = new Employee(rs.getString("eid"), rs.getString("ename"), rs.getString("dept"),
						rs.getString("position"), rs.getString("phone"), rs.getString("state"));
				list.add(emp);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		System.out.println("emplist的长度：" + list.size());
		baseDao.close();
		return list;
	}

	@Override
	public Employee selectByEidAndEname(Employee emp) {
		// TODO Auto-generated method stub
		String sql = "select * from employee where eid=? and ename=?";
		System.out.println("这里是EmpDaoImpl");
		Employee getEmp = null;
		baseDao.open();
		System.out.println("信息！！！：" + emp.getEid() + emp.getEname());
		ResultSet rs = baseDao.execDQL(sql, emp.getEid(), emp.getEname());
		try {
			if (rs.next()) {
				getEmp = new Employee(emp.getEid(), emp.getEname(), rs.getString("dept"), rs.getString("position"),
						rs.getString("phone"), rs.getString("state"));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		baseDao.close();
		return getEmp;
	}

	@Override
	public boolean addAEmp(Employee emp) {
		// TODO Auto-generated method stub
		String sql = "insert into employee values('" + emp.getEid() + "','" + emp.getEname() + "','" + emp.getDept()
				+ "','" + emp.getPosition() + "','" + emp.getPhone() + "','" + emp.getState() + "')";
		baseDao.open();
		baseDao.execDML(sql);

		// 检查数据库中新员工是否已存在
		if (selectByEidAndEname(new Employee(emp.getEid(), emp.getEname())) != null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean deleteAEmp(String eid, String ename) {
		// TODO Auto-generated method stub
		String sql = "delete from employee where eid=" + eid;
		baseDao.open();
		baseDao.execDML(sql);

		// 检查数据库中新员工是否已被删除
		if (selectByEidAndEname(new Employee(eid, ename)) == null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean reviseAEmp(Employee emp) {
		// TODO Auto-generated method stub
		System.out.println(emp.getState());
		String sql = "update employee set ename='"+emp.getEname()+"',"+"dept='"+emp.getDept()+
				"',"+"position='"+emp.getPosition()+"',"+"phone='"+emp.getPhone()+"',"+"state='"+emp.getState()+
				"' "+"where eid="+emp.getEid();
		System.out.println(sql);
		baseDao.open();
		baseDao.execDML(sql);
		
		return true;
	}

}
