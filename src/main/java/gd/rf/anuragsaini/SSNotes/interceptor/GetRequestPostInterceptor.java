package gd.rf.anuragsaini.SSNotes.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

public class GetRequestPostInterceptor implements HandlerInterceptor {

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		if(request.getMethod().equalsIgnoreCase("GET")) {
			String incomeRequest = request.getRequestURI();
			String destinationRequest = new String("./");
			if(incomeRequest.contains("loginprocess")) {
				destinationRequest = "./login";
				response.sendRedirect(destinationRequest);
				System.out.println("[GetRequestPostInterceptor Redirect]: From "+incomeRequest+"(GET) to "+destinationRequest);
			} else if(incomeRequest.contains("registerprocess")) {
				destinationRequest = "./register";
				response.sendRedirect(destinationRequest);
				System.out.println("[GetRequestPostInterceptor Redirect]: From "+incomeRequest+"(GET) to "+destinationRequest);
			} else if(incomeRequest.contains("addpostprocess")) {
				destinationRequest = "./addpost";
				response.sendRedirect(destinationRequest);
				System.out.println("[GetRequestPostInterceptor Redirect]: From "+incomeRequest+"(GET) to "+destinationRequest);
			}
			return false;
		}
		System.out.println("[GetRequestPostInterceptor Redirect]: NO Redirect");
		return true;
	}
	
}
