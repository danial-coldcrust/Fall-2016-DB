package com.ppp.db.view.customer;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ppp.db.delivery.SendService;
import com.ppp.db.delivery.SendVO;
import com.ppp.db.receipt.ReceiptVO;

@Controller
public class SendController {
	@Autowired
	private SendService sendService;

	// 검색 조건 목록 설정
	@ModelAttribute("conditionMap")
	public Map<String, String> searchConditionMap() {
		Map<String, String> conditionMap = new HashMap<String, String>();
		conditionMap.put("처리순번", "send_num");
		conditionMap.put("물품번호", "item_num");
		conditionMap.put("직원번호", "staff_num");
		conditionMap.put("날짜", "date");
		conditionMap.put("시간", "time");
		conditionMap.put("물품위치", "item_position");
		conditionMap.put("처리내용", "handling_state");
		conditionMap.put("수신자", "receiver_name");
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
		model.addAttribute("receipt", sendService.getSend(vo));
		return "getSend.jsp";
	}
	@RequestMapping("/getSendList.do")
	public String getSendList(SendVO vo, Model model){
		// null check
		if(vo.getSearchCondition() == null) vo.setSearchCondition("RECEIPT_NUM");
		if(vo.getSearchKeyword() == null) vo.setSearchKeyword("");
		// model 정보저장
		model.addAttribute("sendList", sendService.getSendList(vo));
		return "getSendList.jsp";
	}
	
}
