package indi.my.hrsys.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import indi.my.hrsys.dao.ResumesDao;
import indi.my.hrsys.db.BaseDao;
import indi.my.hrsys.entity.Employee;
import indi.my.hrsys.entity.Resumes;

public class ResumesDaoImpl implements ResumesDao {
	
	private BaseDao baseDao = new BaseDao();

	@Override
	public List<Resumes> selectAllResumes() {
		// TODO Auto-generated method stub
		String sql = "select * from resumes";
		List<Resumes> list = new ArrayList<Resumes>();
		baseDao.open();
		ResultSet rs = baseDao.execDQL(sql);
		try {
			while (rs.next()) {
				Resumes res = new Resumes(rs.getString("wholename"), rs.getString("sex"), rs.getString("age"),
						rs.getString("workyear"), rs.getString("edulevel"), rs.getString("phone"), rs.getString("aid"));
				list.add(res);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		System.out.println("reslist的长度：" + list.size());
		baseDao.close();
		return list;
	}

	@Override
	public boolean addAResumes(Resumes res) {
		// TODO Auto-generated method stub
		
		String sql = "insert into resumes values('" + res.getWholename() + "','" + res.getSex() + "','" + res.getAge()
				+ "','" + res.getWorkyear() + "','" + res.getEdulevel() + "','" + res.getPhone() + "','" + res.getAid() + "')";
		baseDao.open();
		baseDao.execDML(sql);

		return true;
		// 检查数据库中是否已存在
//		if (selectByEidAndEname(new Employee(emp.getEid(), emp.getEname())) != null) {
//			return true;
//		} else {
//			return false;
//		}
	}

	@Override
	public boolean deleteAResumes(String phone) {
		// TODO Auto-generated method stub
		String sql = "delete from resumes where phone=" + phone;
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

}
