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

@WebServlet("/AllEmp")   
public class EmpAllServlet extends HttpServlet {

	private EmpService empService = new EmpServiceImpl();
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Employee> list = empService.getAll();
		HttpSession session = request.getSession();
		session.setAttribute("empList", list);
//		request.getRequestDispatcher("MainPage.jsp").forward(request, response);
		response.sendRedirect("MainPage.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
