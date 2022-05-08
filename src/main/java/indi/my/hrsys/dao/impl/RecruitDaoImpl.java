package indi.my.hrsys.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import indi.my.hrsys.dao.RecruitDao;
import indi.my.hrsys.db.BaseDao;
import indi.my.hrsys.entity.Employee;
import indi.my.hrsys.entity.Recruit;

public class RecruitDaoImpl implements RecruitDao {
	
	private BaseDao baseDao = new BaseDao();

	@Override
	public List<Recruit> selectAllRecruit() {
		String sql = "select * from recruit";
		List<Recruit> list = new ArrayList<Recruit>();
		baseDao.open();
		ResultSet rs = baseDao.execDQL(sql);
		try {
			while (rs.next()) {
				Recruit rec = new Recruit(rs.getString("pname"), rs.getString("ptype"), rs.getString("worktime"),
						rs.getString("salary"), rs.getString("neednum"), rs.getString("deadline"));
				list.add(rec);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		System.out.println("emplist的长度：" + list.size());
		baseDao.close();
		return list;
	}

	@Override
	public boolean addARecruit(Recruit rec) {
		// TODO Auto-generated method stub
		String sql = "insert into recruit values('" + rec.getPname() + "','" + rec.getPtype() + "','" + rec.getWorktime()
				+ "','" + rec.getSalary() + "','" + rec.getNeednum() + "','" + rec.getDeadline() + "')";
		baseDao.open();
		baseDao.execDML(sql);
		return true;

//		// 检查数据库中新员工是否已存在
//		if (selectByEidAndEname(new Employee(emp.getEid(), emp.getEname())) != null) {
//			return true;
//		} else {
//			return false;
//		}
	}

	@Override
	public boolean deleteARecruit(String pname, String ptype) {
		// TODO Auto-generated method stub
		String sql = "delete from recruit where pname=" + pname;
		baseDao.open();
		baseDao.execDML(sql);
		return true;

		// 检查数据库中新员工是否已被删除
//		if (selectByEidAndEname(new Employee(eid, ename)) == null) {
//			return true;
//		} else {
//			return false;
//		}
	}

	@Override
	public boolean reviseARecruit(Recruit rec) {
		// TODO Auto-generated method stub
		System.out.println(rec.getPname());
		String sql = "update recruit set ptype='" + rec.getPtype() + "'," + "worktime='" + rec.getWorktime() + "',"
				+ "salary='" + rec.getSalary() + "'," + "neednum='" + rec.getNeednum() + "'," + "deadline='"
				+ rec.getDeadline() + "' " + "where pname=" + rec.getPname();
		System.out.println(sql);
		baseDao.open();
		baseDao.execDML(sql);

		return true;
	}

}
