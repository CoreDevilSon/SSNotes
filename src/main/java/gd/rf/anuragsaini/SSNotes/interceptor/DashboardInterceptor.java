package gd.rf.anuragsaini.SSNotes.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

public class DashboardInterceptor implements HandlerInterceptor {

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		if(request.getSession().getAttribute("userInSession") == null) {
			String destination = request.getRequestURI();
			response.sendRedirect("./login");
			System.out.println("[DashboardInterceptor Redirect]: From "+destination+" to ./login");
			return false;
		}
		System.out.println("[DashboardInterceptor Redirect]: NO Redirect");
		return true;
	}
}
