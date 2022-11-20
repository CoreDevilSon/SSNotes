package gd.rf.anuragsaini.SSNotes.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import gd.rf.anuragsaini.SSNotes.entities.User;
import gd.rf.anuragsaini.SSNotes.service.UserService;

@Controller
public class Home {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/register")
	public ModelAndView register(@ModelAttribute("fields") String fieldsBlank, @ModelAttribute("password") String passwordMatch, @ModelAttribute("email") String emailFound) {
		if(fieldsBlank.equalsIgnoreCase("bindingError")) {
			System.out.println("[Redirect]:To Registration Page due to Fields binding Error");
			return new ModelAndView("registration", "msg", "Please provide valid inputs!");
		} else if(fieldsBlank.equalsIgnoreCase("isBlank")) {
			System.out.println("[Redirect]:To Registration Page due to blank Fields");
			return new ModelAndView("registration", "msg", "Fields can't be left empty");
		} else if(passwordMatch.equalsIgnoreCase("notMatch")) {
			System.out.println("[Redirect]:To Registration Page due to not matching password Fields");
			return new ModelAndView("registration", "msg", "Password's do not match");
		} else if(emailFound.equalsIgnoreCase("alreadyFound")) {
			System.out.println("[Redirect]:To Registration Page due to email already registered");
			return new ModelAndView("registration", "msg", "Email ID Already Registered");
		} else {
			System.out.println("Welcome to Registration Page");
		}
		return new ModelAndView("registration");
	}
	@RequestMapping("/login")
	public ModelAndView login(@ModelAttribute("fields") String fieldsBlank, @ModelAttribute("password") String passwordMatch, @ModelAttribute("details") String detailsCombination) {
		if(fieldsBlank.equalsIgnoreCase("isBlank")) {
			System.out.println("[Redirect]:To Login Page due to blank Fields");
			return new ModelAndView("login", "msg", "Fields can't be left empty");
		} else if (detailsCombination.equalsIgnoreCase("invalid")) {
			System.out.println("[Redirect]:To Login Page due to wrong details");
			return new ModelAndView("login", "msg", "Account with specified details not found");
		}
		else {
			System.out.println("Welcome to Login Page");
		}
		return new ModelAndView("login");
	}
	@RequestMapping(path="/registerprocess", method = RequestMethod.POST)
	public ModelAndView registerFormProcess(@ModelAttribute User user, BindingResult result, RedirectAttributes attribute, HttpSession session) {
		if(result.hasErrors()) {
			attribute.addFlashAttribute("fields", "bindingError");
			return new ModelAndView("redirect:/register");
		} else if(user.getuEmail().isBlank() || user.getuName().isBlank() || user.getuName().isBlank() || user.getuPassword().isBlank() || user.getuPasswordConfirm().isBlank()) {
			attribute.addFlashAttribute("fields", "isBlank");
			return new ModelAndView("redirect:/register");
		} else if(!(user.getuPassword().equals(user.getuPasswordConfirm()))) {
			attribute.addFlashAttribute("password", "notMatch");
			return new ModelAndView("redirect:/register");
		} else {
			User userinDB = userService.findUserInDatabase(user.getuEmail());
			if(userinDB != null) {
				attribute.addFlashAttribute("email", "alreadyFound");
				return new ModelAndView("redirect:/register");
			} else {
				user.setuJoinDate(new Date());
				user.setuLastActive(new Date());
				System.out.print(user);
				this.userService.createUser(user);
				session.setAttribute("justRegistered", "true");
				return new ModelAndView("redirect:/completedRegistration");
			}
		}
	}
	@RequestMapping(path="/loginprocess", method=RequestMethod.POST)
	public ModelAndView loginFormProcess(@RequestParam("uEmail") String userEmailInput, @RequestParam("uPassword") String userPasswordInput, RedirectAttributes attributes, HttpSession session){
		System.out.println("Login Process Executing");
		if(userEmailInput.isBlank() || userPasswordInput.isBlank()) {
			attributes.addFlashAttribute("fields", "isBlank");
			return new ModelAndView("redirect:/login");
		} else {
			User user = userService.findUserInDatabase(userEmailInput);
			if(user != null) {
				System.out.println("[Email]: Found");
				if(userService.validatePasswordInDatabase(user, userPasswordInput)) {
					System.out.println("[Password]: Match");
					session.setMaxInactiveInterval(100);
					session.setAttribute("userInSession", user);
					return new ModelAndView("redirect:/dashboard");
				} else {
					System.out.println("[Password]: Not Match");
					attributes.addFlashAttribute("details", "invalid");
					return new ModelAndView("redirect:/login");
				}
			} else {
				System.out.println("[Email]: Not Found");
				attributes.addFlashAttribute("details", "invalid");
				return new ModelAndView("redirect:/login");
			}
		}
	}
	@RequestMapping(path="/dashboard") 
	public ModelAndView openDashboard(HttpSession session) {
		if(session.getAttribute("userInSession") == null) {
			System.out.println("[Redirect]: To Login Page As You are not logged In");
			return new ModelAndView("redirect:/login");
		}
		else return new ModelAndView("home");
	}
	@RequestMapping(path="/completedRegistration") 
	public ModelAndView doneRegistration(HttpSession session) {
		if(session.getAttribute("justRegistered") == null) return new ModelAndView("redirect:/register");
		if(session.getAttribute("justRegistered").equals("true")) {
			session.removeAttribute("justRegistered");
			return new ModelAndView("rsuccess", "msg", "Registration Successfully Completed");
		}
		else return new ModelAndView("redirect:/register");
		
	}
}
