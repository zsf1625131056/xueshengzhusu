package pers.dzgodly.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import pers.dzgodly.domain.HouseOwner;
import pers.dzgodly.domain.Student;
import pers.dzgodly.service.HouseOwnerService;
import pers.dzgodly.service.StudentService;

@Controller
public class InformationController {

	@Autowired
	private StudentService studentService;
	@Autowired
	private HouseOwnerService houseOwnerService;
	
	@RequestMapping(value="/information")
	public ModelAndView getInformation(ModelAndView mv,HttpServletRequest request,HttpSession session) {
		if(session.getAttribute("student")==null&&session.getAttribute("houseowner")==null) {
			mv.setViewName("loginForm");
			return mv;
		}
		HouseOwner houseOwner=(HouseOwner)session.getAttribute("houseowner");
		Student student=(Student)session.getAttribute("student");
		HouseOwner theHouseOwner=null;
		Student theStudent=null;
		if(student!=null) {
			theHouseOwner=houseOwnerService.findById(Integer.valueOf(request.getParameter("houseOwnerId")));
			mv.addObject("theHouseOwner",theHouseOwner);
		}else if(houseOwner!=null) {
			if(request.getParameter("studentId")!=null)
				theStudent=studentService.findById(request.getParameter("studentId"));
			else theStudent=studentService.findByHouseId(request.getParameter("idHouseInfo"));
			mv.addObject("theStudent",theStudent);
		}
		mv.setViewName("information");
		return mv;
	}
	
}
