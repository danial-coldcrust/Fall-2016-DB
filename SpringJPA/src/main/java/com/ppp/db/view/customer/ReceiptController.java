package com.ppp.db.view.customer;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ppp.db.receipt.ReceiptService;
import com.ppp.db.receipt.ReceiptVO;
@Controller
public class ReceiptController {
	@Autowired
	private ReceiptService receiptService;

	// 검색 조건 목록 설정
	@ModelAttribute("conditionMap")
	public Map<String, String> searchConditionMap() {
		Map<String, String> conditionMap = new HashMap<String, String>();
		conditionMap.put("접수번호", "RECEIPT_NUM");
		conditionMap.put("고객번호", "CUSTOMER_NUM");
		conditionMap.put("물품번호", "ITEM_NUM");
		conditionMap.put("직원번호", "STAFF_NUM");
		conditionMap.put("접수일", "RECEIPT_DATE");
		conditionMap.put("배송방식", "SEND_TYPE");
		conditionMap.put("결제방식", "PAY_TYPE");
		conditionMap.put("배송료", "SEND_PAY");		
		return conditionMap;
	}
	@RequestMapping("/insertReceipt.do")
	public String insertReceipt(ReceiptVO vo){
		receiptService.insertReceipt(vo);
		return "getReceiptList.do";
	}
	@RequestMapping("/updateReceipt.do")
	public String updateReceipt(ReceiptVO vo){
		receiptService.updateReceipt(vo);
		return "getReceiptList.do";
	}
	@RequestMapping("/deleteReceipt.do")
	public String deleteReceipt(ReceiptVO vo){
		receiptService.deleteReceipt(vo);
		return "getReceiptList.do";
	}
	@RequestMapping("/getReceipt.do")
	public String getReceipt(ReceiptVO vo, Model model){
		model.addAttribute("receipt", receiptService.getReceipt(vo));
		return "getReceipt.jsp";
	}
	@RequestMapping("/getReceiptList.do")
	public String getReceiptList(ReceiptVO vo, Model model){
		// null check
		if(vo.getSearchCondition() == null) vo.setSearchCondition("RECEIPT_NUM");
		if(vo.getSearchKeyword() == null) vo.setSearchKeyword("");
		// model 정보저장
		model.addAttribute("receipList", receiptService.getReceiptList(vo));
		return "getReceiptList.jsp";
	}
}
