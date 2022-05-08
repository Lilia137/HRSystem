package indi.my.hrsys.Controller.resume;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import indi.my.hrsys.entity.Resumes;
import indi.my.hrsys.service.ResumeService;
import indi.my.hrsys.service.Impl.ResumeServiceImpl;

/**
 * Servlet implementation class ResumeAddServlet
 */
@WebServlet("/AddResume")
public class ResumeAddServlet extends HttpServlet {
	
	private ResumeService resService = new ResumeServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String wholename = request.getParameter("wholename");
		String sex = request.getParameter("sex");
		String age = request.getParameter("age");
		String workyear = request.getParameter("workyear");
		String edulevel = request.getParameter("edulevel");
		String phone = request.getParameter("phone");
		String aid = request.getParameter("aid");
		response.setContentType("text/html;charset=UTF-8");
		
		System.out.println("aidddddddddddd:"+aid);
		
		Resumes res = new Resumes(wholename,sex,age,workyear,edulevel,phone,aid);
		boolean bool = resService.addAResumes(res);
		
		if(bool==true) {
			response.getWriter().write("<h1>提交简历成功</h1>");
		}else {
			//改不改！！！！！！！！！！！！！！！！！！！！！！
			response.getWriter().write("<h1>提交失败</h1>");
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
