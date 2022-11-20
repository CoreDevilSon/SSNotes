package gd.rf.anuragsaini.SSNotes.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

public class AuthenticateInterceptor implements HandlerInterceptor {

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		if(request.getSession().getAttribute("userInSession") != null) {
			response.sendRedirect("./dashboard");
			System.out.println("Redirect from PRE HANDLER");
			return false;
		}
		System.out.println("NO Redirect from PRE HANDLER");
		return true;
	}
	
}
