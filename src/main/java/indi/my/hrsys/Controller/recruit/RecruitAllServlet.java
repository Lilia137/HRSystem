package indi.my.hrsys.Controller.recruit;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import indi.my.hrsys.entity.Recruit;
import indi.my.hrsys.service.RecruitService;
import indi.my.hrsys.service.Impl.RecruitServiceImpl;


/**
 * Servlet implementation class RecruitAllServlet
 */
@WebServlet("/AllRecruit")
public class RecruitAllServlet extends HttpServlet {

	private RecruitService recService = new RecruitServiceImpl();
	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Recruit> list = recService.getAll();
		HttpSession session = request.getSession();
		session.setAttribute("recList", list);
		//区分是外部请求还是内部请求
		if(request.getParameter("from")!=null) {
			response.sendRedirect("OutRecPage.jsp");
		}else {
			response.sendRedirect("RecMainPage.jsp");
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
