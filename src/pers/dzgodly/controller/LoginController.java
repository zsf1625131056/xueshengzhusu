package pers.dzgodly.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import pers.dzgodly.domain.HouseInfo;
import pers.dzgodly.domain.HouseOwner;
import pers.dzgodly.domain.Student;
import pers.dzgodly.service.HouseListService;
import pers.dzgodly.service.LoginService;

/**   
 * @author DZGodly @github   
 * @version V1.0 beta 
 */
@Controller
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	@Autowired
	private HouseListService houseListService;

	@RequestMapping(value="/")
	public String loginForm(){
		return "loginForm";
	}
	@RequestMapping(value="/login")
	 public ModelAndView login(
			 String loginId,String password,String role,
			 ModelAndView mv,
			 HttpSession session){
		//清除之前的登陆状态
		session.removeAttribute("student");
		session.removeAttribute("houseowner");
		
		HouseOwner houseOwner=loginService.ownerLogin(loginId, password);
		Student student=loginService.studentLogin(loginId, password);
		if(role!=null&&role.equals("houseowner")&&(houseOwner!=null)) {
			session.setAttribute("houseowner", houseOwner);
		}else if (role!=null&&role.equals("student")&&(student!=null)) {
			session.setAttribute("student", student);
		}else {
			// 登录失败，设置失败提示信息，并跳转到登录页面
			mv.addObject("message", "登录名或密码错误，请检查您的身份后重新输入!");
			mv.setViewName("/loginForm");
			return mv;
		}
		List<HouseInfo> house_list = houseListService.getHouseList();
		mv.addObject("house_list", house_list);
		mv.setViewName("redirect:/main.jsp");
		return mv;
	}
	
}
