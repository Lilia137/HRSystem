package indi.my.hrsys.Controller.emp;

import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import indi.my.hrsys.entity.Employee;


@WebServlet("/SearchEmp")
public class EmpSearchServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tip = request.getParameter("tip");
		String content = request.getParameter("content");
		
		HttpSession session = request.getSession();
		List<Employee> list = (List<Employee>) session.getAttribute("empList");
		List<Employee> subList = new ArrayList<Employee>();
		for(Employee e : list) {
			if(tip=="ename") {
				
			}
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
