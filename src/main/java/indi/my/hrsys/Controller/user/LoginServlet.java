package indi.my.hrsys.Controller.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import indi.my.hrsys.entity.Userinfo;
import indi.my.hrsys.service.UserinfoService;
import indi.my.hrsys.service.Impl.UserinfoServiceImpl;


@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	
	private UserinfoService userinfoService = new UserinfoServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("===================login=====================");
		String userid = request.getParameter("userid");
		String userpsw = request.getParameter("userpsw");
		System.out.println("userid"+userid);
		Userinfo user = userinfoService.login(userid, userpsw);
//		System.out.println(user.toString());
		
		String viewName = "Login.jsp";      
		if(user!=null) {
			System.out.println(user);
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", user);
					session.setMaxInactiveInterval(1*60);
			viewName="Index.jsp";
		}else{
			System.out.println(user);
			request.setAttribute("isOK", false);
		}
		request.getRequestDispatcher(viewName).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
