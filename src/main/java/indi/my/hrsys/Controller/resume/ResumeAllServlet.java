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
 * Servlet implementation class ResumeAllServlet
 */
@WebServlet("/AllResumes")
public class ResumeAllServlet extends HttpServlet {
	
	private ResumeService resService = new ResumeServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Resumes> list = resService.getAll();
		HttpSession session = request.getSession();
		session.setAttribute("resList", list);
//		String aid = request.getAttribute("aid")
//		request.getRequestDispatcher("MainPage.jsp").forward(request, response);
		if(request.getParameter("aid")!=null) {
			request.setAttribute("aid", request.getParameter("aid"));
		}
		request.getRequestDispatcher("ResPage.jsp").forward(request, response);;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
