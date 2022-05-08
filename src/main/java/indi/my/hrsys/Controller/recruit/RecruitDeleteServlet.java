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
 * Servlet implementation class RecruitDeleteServlet
 */
@WebServlet("/DeleteRecruit")
public class RecruitDeleteServlet extends HttpServlet {
	
	private RecruitService recService = new RecruitServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		List<Recruit> list = (List<Recruit>) session.getAttribute("recList");
		String strIndex = request.getParameter("did");	//接收要删除的索引号（字符串型）
		int index = Integer.parseInt(strIndex);
		String pname = list.get(index).getPname();	//根据eid从数据库里面删除该信息
		String ptype = list.get(index).getPtype();
		response.setContentType("text/html;charset=UTF-8");
		
		//service
		boolean bool = recService.deleteRecruit(pname, ptype);
		if(bool==true) {
			request.getRequestDispatcher("AllRecruit").forward(request, response);
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
