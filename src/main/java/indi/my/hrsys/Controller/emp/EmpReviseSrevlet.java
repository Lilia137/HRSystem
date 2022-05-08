package indi.my.hrsys.Controller.emp;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import indi.my.hrsys.entity.Employee;
import indi.my.hrsys.service.EmpService;
import indi.my.hrsys.service.Impl.EmpServiceImpl;

/**
 * Servlet implementation class EmpRevise
 */
@WebServlet("/ReviseEmp")
public class EmpReviseSrevlet extends HttpServlet {
	
	private EmpService empService = new EmpServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		HttpSession session = request.getSession();
//		List<Employee> list = (List<Employee>) session.getAttribute("empList");
//		String strIndex = request.getParameter("rid");	//接收要删除的索引号（字符串型）
//		int index = Integer.parseInt(strIndex);
		String eid = request.getParameter("eid");
		String ename = request.getParameter("ename");
		String dept = request.getParameter("dept");
		String position = request.getParameter("position");
		String phone = request.getParameter("phone");
		String state = request.getParameter("state");
		response.setContentType("text/html;charset=UTF-8");
		
		Employee emp = new Employee(eid,ename,dept,position,phone,state);
		boolean bool = empService.reviseEmp(emp);
		
		if(bool==true) {
			request.getRequestDispatcher("AllEmp").forward(request, response);
		}else {
			//改不改！！！！！！！！！！！！！！！！！！！！！！
			response.getWriter().write("<h1>修改失败</h1>");
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
