package com.ppp.db.view.customer;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ppp.db.staff.StaffService;
import com.ppp.db.staff.StaffVO;

@Controller
@SessionAttributes("staff")
public class StaffController {
	@Autowired
	private StaffService staffService;

	// 검색 조건 목록 설정
	@ModelAttribute("conditionMap")
	public Map<String, String> searchConditionMap() {
		Map<String, String> conditionMap = new HashMap<String, String>();
		conditionMap.put("직원번호", "STAFF_NUM");
		conditionMap.put("지점", "OFFICE_NUM");
		conditionMap.put("직책", "STAFF_JOB");
		conditionMap.put("직원이름", "STAFF_NAME");
		conditionMap.put("전화번호", "STAFF_PHONENUM");
		return conditionMap;
	}
	
	@RequestMapping("/insertStaff.do")
	public String insertStaff(StaffVO vo){
		staffService.insertStaff(vo);
		return "getStaffList.do";
	}
	
	@RequestMapping("/updatetStaff.do")
	public String updateStaff(@ModelAttribute("staff") StaffVO vo){
		staffService.updateStaff(vo);
		return "getStaffList.do";
	}
	
	@RequestMapping("/deleteStaff.do")
	public String deleteStaff(StaffVO vo){
		staffService.deleteStaff(vo);
		return "getStaffList.do";
	}
	
	@RequestMapping("/getStaff.do")
	public String getStaff(StaffVO vo, Model model){
		model.addAttribute("staff", staffService.getStaff(vo));
		return "getStaff.jsp";
	}
	
	@RequestMapping("/getStaffList.do")
	public String getStaffList(StaffVO vo, Model model){
		// null check
		if(vo.getSearchCondition() == null) vo.setSearchCondition("STAFF_NUM");
		if(vo.getSearchKeyword() == null) vo.setSearchKeyword("");
		// model 정보저장
		model.addAttribute("staffList", staffService.getStaffList(vo));
		return "getStaffList.jsp";
	}
	
	@RequestMapping("/staffLogin.do")
	public String loing(StaffVO vo,HttpSession session){
		if(staffService.getStaff(vo) != null){
			StaffVO staff = staffService.getStaff(vo);
			session.setAttribute("s_name", staff.getStaff_name());
			return "getStaffList.do";
		}
		else return "staffLogin.jsp";
	}
	
	@RequestMapping("/staffLogOut.do")
	public String logout(HttpSession session){
		session.invalidate();
		return "staffLogin.jsp";
	}
}
