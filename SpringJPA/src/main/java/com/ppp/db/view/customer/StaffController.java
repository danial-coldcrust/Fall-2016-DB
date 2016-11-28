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
	
	@RequestMapping("/updateStaff.do")
	public String updateStaff(StaffVO vo){
		staffService.updateStaff(vo);
		return "getStaffList.do";
	}
	
	@RequestMapping("/deleteStaff.do")
	public String deleteStaff(StaffVO vo){
		staffService.deleteStaff(vo);
		return "getStaffList.do";
	}
	/*
	한페이지에서 추가/삭제/검색/수정 구현해서 필요없어짐
	@RequestMapping("/getStaff.do")
	public String getStaff(StaffVO vo, Model model){
		model.addAttribute("staff", staffService.getStaff(vo));
		return "getStaff.jsp";
	}
	*/
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
			StaffVO staff = staffService.getStaff(vo);//getStaff 메소드는 staff_num으로만 체크
			session.setAttribute("s_name", staff.getStaff_name());
			//그러므로 비밀번호체크하는 기능을 넣어야함! 아래는 그에 해당하는 소스
			// 로그인할때 받아온 패스워드가 6보다 작으면 아래 서브스트링할떄오류발생하므로 예외처리!
			if ((vo.getStaff_residentnum().length())!=6) return "staffLogin.jsp";
			// 6자리이면서 , DB에 저장된 staff의 주민번호 앞자리 6개랑 패스워드 6자리가 동일하면 
			if (vo.getStaff_residentnum().substring(0, 5).equals(
					staff.getStaff_residentnum().substring(0, 5)))
				return "getStaffList.do";
			else
				return "staffLogin.jsp";
		}
		else return "staffLogin.jsp";
	}
	
	@RequestMapping("/staffLogOut.do")
	public String logout(HttpSession session){
		session.invalidate();
		return "staffLogin.jsp";
	}
}
