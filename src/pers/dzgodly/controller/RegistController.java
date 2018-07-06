package pers.dzgodly.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import pers.dzgodly.service.RegistService;

@Controller
public class RegistController {

	@Autowired
	private RegistService registService;
	
	@RequestMapping(value="/regist")
	public ModelAndView loginForm(String name,String password,String phone,
			String location,String studentAge,String gender,
			 ModelAndView mv, HttpSession session){
		Integer id=new Integer(-1);
		if(studentAge!=null) {
			id=registService.insertStudent(password, name, location, phone, studentAge, gender);
		}else {
			id=registService.insertHouseOwner(password, name, location, phone);
		}
		mv.addObject("message", new String("注册成功，请登陆~你的账号是"+id.toString()));
		mv.setViewName("/loginForm");
		return mv;
	}
}
