package pers.dzgodly.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import pers.dzgodly.domain.HouseInfo;
import pers.dzgodly.domain.HouseOwner;
import pers.dzgodly.domain.MeetInfo;
import pers.dzgodly.domain.Student;
import pers.dzgodly.service.HouseListService;
import pers.dzgodly.service.InvationService;

@Controller
public class MeetController {

	@Autowired
	private InvationService invationService;
	@Autowired
	private HouseListService houseListService;
	
	/*@RequestMapping(value="/meet")
	public String meetInvation(String studentId,String houseOwnerId,String meetTime,String meetLocation) {
		invationService.insert(studentId, houseOwnerId, meetTime, meetLocation);
		return "main";
	}*/
	@RequestMapping(value="/meet")
	public String meetInvation(HttpServletRequest request,HttpSession session) {
		if(session.getAttribute("student")==null&&session.getAttribute("houseowner")==null) {
			return "loginForm";
		}
		String houseId=request.getParameter("houseId");
		String studentId=((Student)session.getAttribute("student")).getStudentId().toString();
		String houseOwnerId=request.getParameter("houseOwnerId");
		invationService.insert(houseId,studentId, houseOwnerId, null, null);
		return "main";
	}
	
	@RequestMapping(value="/showInvation")
	public ModelAndView showInvation(ModelAndView mv,HttpSession session) {
		Student student=(Student)session.getAttribute("student");
		HouseOwner houseOwner=(HouseOwner)session.getAttribute("houseowner");
		List<MeetInfo> meetInfos=null;
		List<HouseInfo> houseInfos=new ArrayList<HouseInfo>();
		if(student!=null) {
			meetInfos=invationService.showSendInvations(student.getStudentId().toString());
		}else if(houseOwner!=null){
			meetInfos=invationService.showAcptInvations(houseOwner.getHouseOwnerId().toString());
		}else {
			mv.setViewName("loginForm");
			return mv;
		}
		for(MeetInfo meetInfo:meetInfos) {
			houseInfos.add(houseListService.findHouseById(meetInfo.getIdHouseInfo()));
		}
		mv.addObject("meetInfos", meetInfos);
		mv.addObject("houseInfos", houseInfos);
		mv.setViewName("showInvation");
		return mv;
	}
	
	@RequestMapping(value="/handleInvation")
	public String handleInvation(HttpServletRequest request) {
		String state=request.getParameter("state");
		if(state.equals("4")) {
			invationService.delete(request.getParameter("idMeetInfo"));
			return "redirect:/showInvation";
		}
		String idMeetInfo=request.getParameter("idMeetInfo");
		invationService.updateState(state, idMeetInfo);
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat  sf = new SimpleDateFormat("yyyy-MM-dd");
		cal.add(Calendar.DATE, 2);//约定两天后上午10.30在厦门xx咖啡厅见面
		invationService.update(sf.format(cal.getTime())+" 10:00:00","厦门xx咖啡厅", idMeetInfo);
		return "redirect:/showInvation";
	}
	
	
}
