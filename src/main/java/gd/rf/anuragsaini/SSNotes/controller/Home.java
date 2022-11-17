package gd.rf.anuragsaini.SSNotes.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import gd.rf.anuragsaini.SSNotes.dao.UserDao;
import gd.rf.anuragsaini.SSNotes.entities.User;
import gd.rf.anuragsaini.SSNotes.service.UserService;

@Controller
public class Home {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/register")
	public ModelAndView register(@ModelAttribute("fields") String fieldsBlank, @ModelAttribute("password") String passwordMatch) {
		if(fieldsBlank.equalsIgnoreCase("isBlank")) {
			System.out.println("[Redirect]:To Registration Page due to blank Fields");
			return new ModelAndView("registration", "msg", "Fields can't be left empty");
		} else if(passwordMatch.equalsIgnoreCase("notMatch")) {
			System.out.println("[Redirect]:To Registration Page due to not matching password Fields");
			return new ModelAndView("registration", "msg", "Password's do not match");
		}
		else {
			System.out.println("Welcome to Registration Page");
		}
		return new ModelAndView("registration");
	}
	@RequestMapping("/login")
	public ModelAndView login(@ModelAttribute("fields") String fieldsBlank, @ModelAttribute("password") String passwordMatch) {
		if(fieldsBlank.equalsIgnoreCase("isBlank")) {
			System.out.println("[Redirect]:To Login Page due to blank Fields");
			return new ModelAndView("login", "msg", "Fields can't be left empty");
		} else {
			System.out.println("Welcome to Login Page");
		}
		return new ModelAndView("login");
	}
	@RequestMapping(path="/registerprocess", method = RequestMethod.POST)
	public ModelAndView registerFormProcess(@ModelAttribute User user, RedirectAttributes attribute) {
		user.setuJoinDate(new Date());
		user.setuLastActive(new Date());
		attribute.addFlashAttribute(user);
		if(user.getuEmail().isBlank() || user.getuName().isBlank() || user.getuName().isBlank() || user.getuPassword().isBlank() || user.getuPasswordConfirm().isBlank()) {
			attribute.addFlashAttribute("fields", "isBlank");
			return new ModelAndView("redirect:/register");
		} else if(!(user.getuPassword().equals(user.getuPasswordConfirm()))) {
			attribute.addFlashAttribute("password", "notMatch");
			return new ModelAndView("redirect:/register");
		}
		System.out.print(user);
		this.userService.createUser(user);
		return new ModelAndView("rsuccess", "msg", "Account Registered Successfully!");
	}
	@RequestMapping(path="/loginprocess", method=RequestMethod.POST)
	public ModelAndView loginFormProcess(@RequestParam("uEmail") String userEmailInput, @RequestParam("uPassword") String userPasswordInput, RedirectAttributes attributes){
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
				} else {
					System.out.println("[Password]: Not Match");
				}
			} else {
				System.out.println("[Email]: Not Found");
			}
		}
		System.out.println("Email Entered:"+userEmailInput);
		System.out.println("Password Entered:"+userPasswordInput);
		return new ModelAndView("/login");
	}
}
