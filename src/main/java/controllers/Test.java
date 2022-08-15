package controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Test {
	@RequestMapping("/register")
	public String register() {
		System.out.println("Welcome to Registration Page");
		return "registration";
	}
	@RequestMapping("/login")
	public String login() {
		System.out.println("Welcome to Login Page");
		return "login";
	}
}
