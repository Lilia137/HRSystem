package indi.my.hrsys.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;


//@WebFilter("/*")
public class SessionFilter implements Filter {

	private String passUris;
    public SessionFilter() {
        // TODO Auto-generated constructor stub
    }


	public void destroy() {
		// TODO Auto-generated method stub
	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("session过滤器在这~");
		HttpServletRequest req =(HttpServletRequest) request;
		System.out.println(req.getRequestURI());
		
		String uri = req.getRequestURI();
		if(uri.endsWith("/Login")||uri.endsWith("Login.jsp")||uri.endsWith("Reg.jsp")
				||uri.endsWith("/Register")||uri.endsWith("/AllRecruit")
				||uri.endsWith("/OutRecPage.jsp")||uri.endsWith("/AddRes.jsp")
				||uri.endsWith("/AddResume")||uri.endsWith("/css/login.css")) {
			chain.doFilter(request, response);
		}else {
			if(req.getSession().getAttribute("loginUser")==null) {
				response.setContentType("text/html;charset=utf-8");
		    	response.getWriter().write("<script>alert('非法链接') ;  location.href='Login.jsp'</script>");
			}else {
				chain.doFilter(request, response);
			}
		}
//		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		passUris = fConfig.getInitParameter("pass");
		
	}

}
