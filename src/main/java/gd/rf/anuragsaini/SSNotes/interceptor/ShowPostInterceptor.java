package gd.rf.anuragsaini.SSNotes.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import gd.rf.anuragsaini.SSNotes.entities.Post;
import gd.rf.anuragsaini.SSNotes.entities.User;
import gd.rf.anuragsaini.SSNotes.service.PostService;

public class ShowPostInterceptor implements HandlerInterceptor {

	@Autowired
	PostService postService;
	
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		if(request.getSession().getAttribute("sessionUserPosts") == null) {
			User userObjInSession = (User) request.getSession().getAttribute("userInSession");
			if(userObjInSession != null) {
				System.out.println("[ShowPostInterceptor]: Querying Database for Data");
				List<Post> postOfSessionUser = postService.getAllUserPostByEmail(userObjInSession.getuEmail());
				if(postOfSessionUser.size() > 0) {
					request.getSession().setAttribute("sessionUserPosts", postOfSessionUser);
					request.getSession().setAttribute("postsFound", true);
					System.out.println("Added");
				} else {
					modelAndView.addObject("postsFound", false);
				}
			} else System.out.println("[ShowPostInterceptor]: User Not In Session");
		} else {
			System.out.println("[ShowPostInterceptor]: No Querying to Database for Data");
		}
	} 
}

