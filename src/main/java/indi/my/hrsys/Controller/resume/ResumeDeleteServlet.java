package indi.my.hrsys.Controller.resume;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import indi.my.hrsys.entity.Resumes;
import indi.my.hrsys.service.ResumeService;
import indi.my.hrsys.service.Impl.ResumeServiceImpl;

/**
 * Servlet implementation class ResumeDeleteServlet
 */
@WebServlet("/DeleteResume")
public class ResumeDeleteServlet extends HttpServlet {
	
	private ResumeService resService = new ResumeServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		List<Resumes> list = (List<Resumes>) session.getAttribute("resList");
		String strIndex = request.getParameter("did");	//接收要删除的索引号（字符串型）
		int index = Integer.parseInt(strIndex);
		String phone = list.get(index).getPhone();	//根据eid从数据库里面删除该信息
		String aid = list.get(index).getAid();
		request.setAttribute("aid", aid);
		response.setContentType("text/html;charset=UTF-8");
		
		//service
		boolean bool = resService.deleteAResumes(phone);
		if(bool==true) {
			request.getRequestDispatcher("AllResumes").forward(request, response);
		}else {
			//改不改！！！！！！！！！！！！！！！！！！！！！！
			response.getWriter().write("<h1>删除失败</h1>");
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
