package indi.my.hrsys.Controller.user;

import java.io.IOException;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import indi.my.hrsys.entity.Userinfo;
import indi.my.hrsys.service.UserinfoService;
import indi.my.hrsys.service.Impl.UserinfoServiceImpl;


@WebServlet("/Register")
public class RegServlet extends HttpServlet implements Servlet {

	private UserinfoService userinfoService = new UserinfoServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid = request.getParameter("userid");
		String userpsw = request.getParameter("userpsw");
		String nickname = request.getParameter("nickname");
		String headpic = request.getParameter("headpic");
		response.setContentType("text/html;charset=UTF-8");
		boolean bool = userinfoService.register(userid, userpsw, nickname,headpic);
		
		if(bool==true) {
			Userinfo user = new Userinfo(userid,userpsw,nickname,headpic);
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", user);
			session.setMaxInactiveInterval(1*60);
			request.getRequestDispatcher("AllEmp").forward(request, response);
		}else {
			response.getWriter().write("<h1>注册失败</h1>");
		}
		
		System.out.println("Reg的doGet方法被调用");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
