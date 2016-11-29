package com.ppp.db.view.customer;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ppp.db.send.SendService;
import com.ppp.db.send.SendVO;

@Controller
@SessionAttributes("send")
public class SendController {
	@Autowired
	private SendService sendService;

	// 검색 조건 목록 설정
	@ModelAttribute("conditionMap")
	public Map<String, String> searchConditionMap() {
		Map<String, String> conditionMap = new HashMap<String, String>();
		conditionMap.put("처리순번", "SEND_NUM");
		conditionMap.put("물품번호", "ITEM_NUM");
		conditionMap.put("직원번호", "STAFF_NUM");
		conditionMap.put("날짜", "DATE");
		conditionMap.put("시간", "TIME");
		conditionMap.put("물품위치", "ITEM_POSITION");
		conditionMap.put("처리내용", "HANDLING_STATE");
		conditionMap.put("수신자", "RECEIVER_NAME");
		return conditionMap;
	}

	@RequestMapping("/insertSend.do")
	public String insertSend(SendVO vo) {
		sendService.insertSend(vo);
		return "getSendList.do";
	}
	@RequestMapping("/updateSend.do")
	public String updateSend(SendVO vo) {
		sendService.updateSend(vo);
		return "getSendList.do";
	}
	@RequestMapping("/deleteSend.do")
	public String deleteSend(SendVO vo) {
		sendService.deleteSend(vo);
		return "getSendList.do";
	}
	@RequestMapping("/getSend.do")
	public String getSend(SendVO vo, Model model){
		model.addAttribute("send", sendService.getSend(vo));
		return "getSend.jsp";
	}
	@RequestMapping("/getSendList.do")
	public String getSendList(SendVO vo, Model model){
		// null check
		if(vo.getSearchCondition() == null) vo.setSearchCondition("SEND_NUM");
		if(vo.getSearchKeyword() == null) vo.setSearchKeyword("");
		// model 정보저장
		model.addAttribute("sendList", sendService.getSendList(vo));
		return "getSendList.jsp";
	}
	
}
