package indi.my.hrsys.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import indi.my.hrsys.dao.UserinfoDao;
import indi.my.hrsys.db.BaseDao;
import indi.my.hrsys.entity.Userinfo;
import indi.my.hrsys.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.enterprise.inject.spi.Bean;

public class UserinfoDaoImpl implements UserinfoDao {
	private BaseDao baseDao = new BaseDao();
	JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
//	@Override
//	public List<Userinfo> selectAll(){
//		String sql =  "select * from userinfo";
//		
//		List<Userinfo> list = new ArrayList<Userinfo>();
//		baseDao.open();
//		ResultSet rs = baseDao.execDQL(sql);
//		
//		try {
//			while(rs.next()) {
//				//此处在userInfo中添加构造方法
//				list.add(new Userinfo(rs.getString("userid"),
//						"******",   
//						rs.getString("nickname"),
//						rs.getString("headpic")));
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		return list;
//	}
	
	
	@Override
	public Userinfo selectByUseridAndUserpsw(Userinfo userinfo){
//		String sql = "select * from userinfo where userid=? and userpsw=?";
//		System.out.println("这里是UserInfoDaoImpl");
//		Userinfo getUser = null;
//		baseDao.open();
//		System.out.println("信息！！！："+userinfo.getUserid()+userinfo.getUserpsw());
//		ResultSet rs = baseDao.execDQL(sql,userinfo.getUserid(),userinfo.getUserpsw());
//		try {
//			if (rs.next()) {
//				getUser = new Userinfo(
//						userinfo.getUserid(),
//						"******",
//						rs.getString("nickname"),
//						rs.getString("headpic"));
//			}
//		} catch (Exception ex) {
//			ex.printStackTrace();
//		}
//
//		baseDao.close();
//		return getUser;
		Userinfo userinfo1 = null;
		try{
			userinfo1 = template.queryForObject("select * from userinfo where userid=? and userpsw=?", new BeanPropertyRowMapper<Userinfo>(Userinfo.class), userinfo.getUserid(), userinfo.getUserpsw());
		}catch(Exception e){

		}
		return userinfo1;
	}
	
	@Override
	public boolean putInRegisterData(Userinfo user) {
		
//		List<Userinfo> list = selectAll();
//		int seqNum = list.size()+1;
		
		String sql = "insert into userinfo values('"+user.getUserid()+"','"+user.getUserpsw()+"','"+user.getNickname()+"','"+user.getHeadpic()+"')";
		baseDao.open();
		baseDao.execDML(sql);
		
		//检查数据库中新用户是否已存在
		if(selectByUseridAndUserpsw(new Userinfo(user.getUserid(),user.getUserpsw()))!=null){
			return true;
		}else {
			return false;
		}
	}
}
