package indi.my.hrsys.Controller.recruit;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import indi.my.hrsys.entity.Employee;
import indi.my.hrsys.entity.Recruit;
import indi.my.hrsys.service.EmpService;
import indi.my.hrsys.service.RecruitService;
import indi.my.hrsys.service.Impl.EmpServiceImpl;
import indi.my.hrsys.service.Impl.RecruitServiceImpl;

/**
 * Servlet implementation class RecruitAddServlet
 */
@WebServlet("/AddRecruit")
public class RecruitAddServlet extends HttpServlet {
	
	private RecruitService recService = new RecruitServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pname = request.getParameter("pname");
		String ptype = request.getParameter("ptype");
		String worktime = request.getParameter("worktime");
		String salary = request.getParameter("salary");
		String neednum = request.getParameter("neednum");
		String deadline = request.getParameter("deadline");
		response.setContentType("text/html;charset=UTF-8");
		
		Recruit rec = new Recruit(pname,ptype,worktime,salary,neednum,deadline);
		boolean bool = recService.addRecruit(rec);
		
		if(bool==true) {
			request.getRequestDispatcher("AllRecruit").forward(request, response);
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
