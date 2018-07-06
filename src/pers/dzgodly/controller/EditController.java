package pers.dzgodly.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import pers.dzgodly.service.HouseOwnerService;
import pers.dzgodly.service.StudentService;

@Controller
public class EditController {
	@Autowired
	private HouseOwnerService houseOwnerService;
	@Autowired
	private StudentService studentService;
	
	@RequestMapping(value="/edit")
	public String edit(String studentPhone,String studentLocation,
			String studentAge,String gender,String studentId,String houseOwnerId,HttpSession session) {
		if(session.getAttribute("student")==null&&session.getAttribute("houseowner")==null) {
			return "loginForm";
		}
		if(studentId!=null) {
			studentService.updateStudent(studentId, studentPhone, studentLocation, studentAge, gender);
			session.setAttribute("student",studentService.findById(studentId));
		}else {
			houseOwnerService.updateHouseOwner(houseOwnerId, studentPhone, studentLocation);
			session.setAttribute("houseowner",houseOwnerService.findById(Integer.valueOf(houseOwnerId)));
		}
		return "/main";
	}
	@RequestMapping(value="/editProfile")
	public String editProfile(HttpSession session) {
		if(session.getAttribute("student")==null&&session.getAttribute("houseowner")==null) {
			return "loginForm";
		}
		return "editProfile";
	}
}
