package gd.rf.anuragsaini.SSNotes.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import gd.rf.anuragsaini.SSNotes.entities.User;
import gd.rf.anuragsaini.SSNotes.service.UserService;

@Controller
public class Home {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("register")
	public String register() {
		System.out.println("Welcome to Registration Page");
		return "registration";
	}
	@RequestMapping("login")
	public String login() {
		System.out.println("Welcome to Login Page");
		return "login";
	}
	@RequestMapping(path="registerprocess", method = RequestMethod.POST)
	public String registerFormProcess(@ModelAttribute User user) {
		user.setuJoinDate(new Date());
		user.setuLastActive(new Date());
		System.out.print(user);
		this.userService.createUser(user);
		return "rsuccess";
	}
}
