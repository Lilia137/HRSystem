package indi.my.hrsys.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDao {
	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:orcl";
	private static final String USERNAME = "system";
	private static final String PSW = "system";
	
	
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	static {
		try {
			//静态块中驱动只在JVM中执行一次
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	//打开连接
	public void open() {
		try {
			this.conn = DriverManager.getConnection(URL,USERNAME,PSW);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//dml和dql中的冗余代码,用于完善statement
	private void makePrepareStatement(String sql,Object...param) {
		try {
			System.out.println("BaseDao.makePrepareStatement()");
			this.ps = conn.prepareStatement(sql);
			for(int i=0;i<param.length;i++) {
				this.ps.setObject(i+1, param[i]);
			}
		} catch (Exception ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		
	}
	
	
	//执行update / delete / insert
	//使用可变传参，因为sql中的参数个数和类型不确定
	public int execDML(String sql,Object...param) {
		try {
			this.makePrepareStatement(sql, param);
			this.ps.executeUpdate();
		} catch (Exception ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		return -1;
		
	}
	
	
	//查询
	public ResultSet execDQL(String sql,Object...param) {
		//报错
		System.out.println("execDQL!!!");
		System.out.println("param.length::"+param.length);
		try {
			System.out.println("try sql");
			this.makePrepareStatement(sql, param);
			return this.ps.executeQuery();
		} catch (Exception ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		System.out.println("dql出错了出错了！！");

		return null;
	}
	
	//关闭连接
	public void close() {
		//先关rs，再关ps，最后关conn
		if(this.rs!=null) { 
			try {
				this.rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				this.rs=null;
			}
		}
		
		if(this.ps!=null) { 
			try {
				this.ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				this.ps=null;
			}
		}
		
		//先判断conn是否为空，避免出现空指针异常
		if(this.conn!=null) { 
			try {
				this.conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				this.conn=null;
			}
		}
	
	}
}
