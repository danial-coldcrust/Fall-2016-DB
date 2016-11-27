package com.ppp.db.view.customer;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ppp.db.office.OfficeService;
import com.ppp.db.office.OfficeVO;

@Controller
@SessionAttributes("office")
public class OfficeController {
	@Autowired
	private OfficeService officeService;
	// 검색 조건 목록 설정
	@ModelAttribute("conditionMap")
	public Map<String, String> searchConditionMap() {
		Map<String, String> conditionMap = new HashMap<String, String>();
		conditionMap.put("지점 번호", "OFFICE_NUM");
		conditionMap.put("지점 이름", "OFFICE_NAME");
		return conditionMap;
	}
	@RequestMapping("/insertOffice.do")
	public String insertOffice(OfficeVO vo) {
		officeService.insertOffice(vo);
		return "getOfficeList.do";
	}
	@RequestMapping("/updateOffice.do")
	public String updateOffice(OfficeVO vo) {
		officeService.updateOffice(vo);
		return "getOfficeList.do";
	}
	@RequestMapping("/deleteOffice.do")
	public String deleteOffice(OfficeVO vo) {
		officeService.deleteOffice(vo);
		return "getOfficeList.do";
	}
	/*
	한페이지에서 추가/삭제/검색/수정 구현해서 필요없어짐
	@RequestMapping("/getOffice.do")
	public OfficeVO getOffice(OfficeVO vo) {
		return officeService.getOffice(vo);
	}
	 */
	@RequestMapping("/getOfficeList.do")
	public String getOfficeList(OfficeVO vo, Model model){
		// null check
		if(vo.getSearchCondition() == null) vo.setSearchCondition("OFFICE_NUM");
		if(vo.getSearchKeyword() == null) vo.setSearchKeyword("");
		// model 정보저장
		model.addAttribute("officeList", officeService.getOfficeList(vo));
		return "getOfficeList.jsp";
	}
}
