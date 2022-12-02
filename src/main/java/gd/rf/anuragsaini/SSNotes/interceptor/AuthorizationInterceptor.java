package gd.rf.anuragsaini.SSNotes.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

public class AuthorizationInterceptor implements HandlerInterceptor {

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		if(request.getSession().getAttribute("userInSession") != null) {
			String destination = request.getRequestURI();
			response.sendRedirect("./dashboard");
			System.out.println("[AuthorizationInterceptor Redirect]: From "+destination+" to ./dashboard");
			return false;
		}
		System.out.println("[AuthorizationInterceptor Redirect]: NO Redirect");
		return true;
	}
	
}
