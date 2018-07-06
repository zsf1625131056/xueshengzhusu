package pers.dzgodly.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import pers.dzgodly.domain.HouseInfo;
import pers.dzgodly.domain.HouseOwner;
import pers.dzgodly.domain.Student;
import pers.dzgodly.service.HouseListService;
import pers.dzgodly.service.HouseOwnerService;
import pers.dzgodly.service.InvationService;
import pers.dzgodly.service.StudentService;

@Controller
public class HouseListController {

	@Autowired
	private HouseListService houseListService;
	@Autowired
	private HouseOwnerService houseOwnerService;
	@Autowired
	private StudentService studentService;
	@Autowired
	private InvationService invationService;
	
	@RequestMapping(value="/main")
	 public ModelAndView main(HttpSession session,ModelAndView mv){
		List<HouseInfo> house_list = houseListService.findUnavailable();
		mv.addObject("house_list", house_list);
		mv.setViewName("main");
		return mv;
	}
	
	@RequestMapping(value="/detail")
	public ModelAndView detail(ModelAndView mv,@RequestParam String houseId,HttpSession session) {
		if(session.getAttribute("student")==null&&session.getAttribute("houseowner")==null) {
			mv.setViewName("loginForm");
			return mv;
		}
		HouseInfo houseInfo=null;
		HouseOwner houseOwner=null;
		if(houseId!=null) {
			houseInfo=houseListService.findHouseById(Integer.valueOf(houseId));
			houseOwner=houseOwnerService.findById(houseInfo.getHouseOwnerId());
		}
		if(houseInfo!=null&&houseOwner!=null) {
			mv.addObject("houseInfo", houseInfo);
			mv.addObject("houseOwner", houseOwner);
		}
		mv.setViewName("/detail");
		return mv;
	}
	
	@RequestMapping(value="/manageHouse")
	public ModelAndView manage(HttpSession session,ModelAndView mv) {
		mv.clear();
		if(session.getAttribute("student")==null&&session.getAttribute("houseowner")==null) {
			mv.setViewName("loginForm");
			return mv;
		}
		HouseOwner houseOwner=(HouseOwner)session.getAttribute("houseowner");
		Student student=(Student)session.getAttribute("student");
		List<HouseInfo> houseList=new ArrayList<HouseInfo>();
		if(student!=null&&student.getIdHouseInfo()!=null) {
			houseList.add(houseListService.findHouseById(student.getIdHouseInfo()));
		}else if(houseOwner!=null) {
			houseList=houseListService.findHouseByOwnerId(houseOwner.getHouseOwnerId().toString());
		}
		mv.addObject("houseList", houseList);
		mv.setViewName("manageHouse");
		return mv;
	}
	
	@RequestMapping(value="/deal")
	public String changeAvailable(HttpServletRequest request) {
		houseListService.updateAvailable(request.getParameter("available"), request.getParameter("idHouseInfo"));
		if(request.getParameter("state")!=null) 
			invationService.updateState(request.getParameter("state"), request.getParameter("idMeetInfo"));
		if(request.getParameter("available").equals("1"))
			studentService.updateHouseId(request.getParameter("studentId"),null);
		else studentService.updateHouseId(request.getParameter("studentId"),request.getParameter("idHouseInfo"));
		return "redirect:/manageHouse";
	}
	
	@RequestMapping(value="/deleteHouse")
	public String deleteHouse(HttpServletRequest request,HttpSession session) {
		houseListService.delete(request.getParameter("idHouseInfo"));
		Student student=studentService.findByHouseId(request.getParameter("idHouseInfo"));
		if(student!=null) {
			String studentId=student.getStudentId().toString();
			studentService.updateHouseId(studentId, null);
		}
		return "redirect:/manageHouse";
	}
	
	@RequestMapping(value="/add")
	public String addHouse(String location,String type,String theLimit,String rent,HttpSession session) {
		HouseOwner houseOwner=(HouseOwner)session.getAttribute("houseowner");
		houseListService.insert(houseOwner.getHouseOwnerId().toString(), location, type, theLimit, rent);
		return "redirect:/manageHouse";
	}
	
	@RequestMapping(value="/editHouse")
	public ModelAndView houseDetail(ModelAndView mv,HttpSession session,HttpServletRequest request) {
		session.setAttribute("idHouseInfo", request.getParameter("idHouseInfo"));
		HouseInfo houseInfo=houseListService.findHouseById(Integer.valueOf(request.getParameter("idHouseInfo")));
		mv.addObject("houseInfo", houseInfo);
		mv.setViewName("editHouse");
		return mv;
	}
	
	@RequestMapping(value="/doEditHouse")
	public String edithouseDetail(String location,String type,
			String theLimit,String rent,String available,HttpSession session) {
		houseListService.update(location, type, theLimit, rent, available,session.getAttribute("idHouseInfo").toString());
		session.removeAttribute("idHouseInfo");
		return "redirect:/manageHouse";
	}
}
