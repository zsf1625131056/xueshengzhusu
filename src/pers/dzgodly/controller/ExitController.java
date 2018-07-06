package pers.dzgodly.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExitController {
	@RequestMapping(value="exit")
	public String exit(HttpSession session) {
		session.removeAttribute("student");
		session.removeAttribute("houseowner");
		return "loginForm";
	}

}
