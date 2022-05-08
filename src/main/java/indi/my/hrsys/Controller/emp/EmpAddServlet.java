package indi.my.hrsys.Controller.emp;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import indi.my.hrsys.entity.Employee;
import indi.my.hrsys.entity.Userinfo;
import indi.my.hrsys.service.EmpService;
import indi.my.hrsys.service.Impl.EmpServiceImpl;

@WebServlet("/AddEmp")
public class EmpAddServlet extends HttpServlet {
	
	private EmpService empService = new EmpServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String eid = request.getParameter("eid");
		String ename = request.getParameter("ename");
		String dept = request.getParameter("dept");
		String position = request.getParameter("position");
		String phone = request.getParameter("phone");
		String state = request.getParameter("state");
		response.setContentType("text/html;charset=UTF-8");
		
		Employee emp = new Employee(eid,ename,dept,position,phone,state);
		boolean bool = empService.addEmp(emp);
		
		if(bool==true) {
			request.getRequestDispatcher("AllEmp").forward(request, response);
		}else {
			//改不改！！！！！！！！！！！！！！！！！！！！！！
			response.getWriter().write("<h1>注册失败</h1>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
