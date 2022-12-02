package gd.rf.anuragsaini.SSNotes.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import gd.rf.anuragsaini.SSNotes.entities.Post;
import gd.rf.anuragsaini.SSNotes.entities.User;
import gd.rf.anuragsaini.SSNotes.service.PostService;
import gd.rf.anuragsaini.SSNotes.service.UserService;

@Controller
public class PostController {
	
	@Autowired 
	private PostService postService;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(path="/addpost") 
	public ModelAndView addpost(@ModelAttribute("fields") String fieldsBlank) {
		System.out.println("Welcome to Add Post Page");
		if(fieldsBlank.equalsIgnoreCase("bindingError")) {
			System.out.println("[Redirect]:To Add Post due to Fields binding Error");
			return new ModelAndView("cpost", "msg", "Please provide valid inputs!");
		} else if(fieldsBlank.equalsIgnoreCase("isBlank")) {
			System.out.println("[Redirect]:To Add Post Page due to blank Fields");
			return new ModelAndView("cpost", "msg", "Fields can't be left empty");
		}
		return new ModelAndView("cpost");
	}
	@RequestMapping(path="/addpostprocess", method= {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView postFormProcess(@ModelAttribute Post post, BindingResult result, RedirectAttributes attributes, HttpSession session) {
		System.out.println("Post Creation Executing");
		if(result.hasErrors()) {
			attributes.addFlashAttribute("fields", "bindingError");
			return new ModelAndView("redirect:/addpost");
		} else if(post.getpTitle().isBlank() || post.getpDescription().isBlank() || post.getpVisibility() == null || post.getpVisibility().isBlank()) {
			attributes.addFlashAttribute("fields", "isBlank");
			return new ModelAndView("redirect:/addpost");
		} else {
			User user = (User)session.getAttribute("userInSession");
			post.setpCreateDate(new Date());
			post.setpEditDate(new Date());
			post.setpAuthorEmail(user.getuEmail());
			System.out.println(post);
			int postid = this.postService.createPost(post);
			System.out.println(postid);
			session.removeAttribute("sessionUserPosts");
			return new ModelAndView("redirect:./seepost/"+postid);
		}
	}
	@RequestMapping(path="/editpostprocess", method= {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView postEditFormProcess(@RequestParam("pTitle") String pTitle, @RequestParam("pDescription") String pDescription, @RequestParam("pCode") String pCode, @RequestParam("pVisibility") String pVisibility, RedirectAttributes attributes, HttpSession session) {
		System.out.println("Post Edit Executing");
		if(pTitle.isBlank() || pDescription.isBlank() || pCode.isBlank() || pVisibility.isBlank()) {
			attributes.addFlashAttribute("fields", "isBlank");
			return new ModelAndView("redirect:/editpost");
		} else {
			int id = (Integer) session.getAttribute("pEditId");
			int postid = this.postService.editPostById(id, pCode,  pDescription, new Date(), pTitle, pVisibility);
			System.out.println(postid);
			session.removeAttribute("sessionUserPosts");
			session.removeAttribute("pEditId");
			return new ModelAndView("redirect:./seepost/"+id);
		}
	}
	@RequestMapping(path={"/seepost/{id}", "/seepost/"})
	public ModelAndView showSpecificPost(@PathVariable(name="id", required = false) Integer id, HttpSession session, ModelAndView modelObj) {
		User userInSession = (User)session.getAttribute("userInSession");
		Post post = this.postService.getPostById(id);
		if(post == null) return new ModelAndView("postnotfound");
		else {
			User postOwner = userService.findUserInDatabase(post.getpAuthorEmail());
			modelObj.setViewName("showpost");
			modelObj.addObject("postDetails", post);
			modelObj.addObject("postOwnerName", postOwner.getuName());
			if(post.getpVisibility().equalsIgnoreCase("private")) {
				if(userInSession == null) return new ModelAndView("postnotfound");
				else if(!(post.getpAuthorEmail().equalsIgnoreCase(userInSession.getuEmail()))) return new ModelAndView("postnotfound");
			}
		}
		return modelObj;
	}
	@RequestMapping(path={"/editpost/{id}", "/editpost/"})
	public ModelAndView editSpecificPost(@PathVariable(name="id", required = false) Integer id, HttpSession session, RedirectAttributes attributes) {
		User userInSession = (User)session.getAttribute("userInSession");
		Post post = this.postService.getPostById(id);
		if(post == null || userInSession == null) {
			System.out.println("Redirect to Dashboard as Post/User not found");
			attributes.addFlashAttribute("postUserSession", "notFound");
			return new ModelAndView("redirect:/dashboard");
		} else if(!(post.getpAuthorEmail().equalsIgnoreCase(userInSession.getuEmail()))) {
			attributes.addFlashAttribute("noOwner", "true");
			System.out.println("Redirect to Dashboard as no owner");
			return new ModelAndView("redirect:/dashboard");
		} else {
			session.setAttribute("pEditId", id);
			return new ModelAndView("epost", "postToedit", post);
		}	
	}
	
	@RequestMapping(path={"/deletepost/{id}", "/deletepost/"})
	public ModelAndView deleteSpecificPost(@PathVariable(name="id", required = false) Integer id, HttpSession session, RedirectAttributes attributes) {
		User userInSession = (User)session.getAttribute("userInSession");
		Post post = this.postService.getPostById(id);
		if(post == null || userInSession == null) {
			System.out.println("Redirect to Dashboard as Post/User not found");
			attributes.addFlashAttribute("postUserSession", "notFound");
			return new ModelAndView("redirect:/dashboard");
		} else if(!(post.getpAuthorEmail().equalsIgnoreCase(userInSession.getuEmail()))) {
			attributes.addFlashAttribute("noOwner", "true");
			System.out.println("Redirect to Dashboard as no owner");
			return new ModelAndView("redirect:/dashboard");
		} else {
			this.postService.deletePostById(id);
			session.removeAttribute("sessionUserPosts");
			attributes.addFlashAttribute("msg", "[Activity:] Action Performed");
			return new ModelAndView("redirect:/dashboard");
		}	
	}
	
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	@ExceptionHandler({MethodArgumentTypeMismatchException.class, NullPointerException.class})
	public ModelAndView handelException() {
		return new ModelAndView("postnotfound");
	}
}