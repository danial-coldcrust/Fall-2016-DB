package com.ppp.db.view.customer;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ppp.db.item.ItemService;
import com.ppp.db.item.ItemVO;

@Controller
public class ItemController {
	@Autowired
	private ItemService itemService;

	// 검색 조건 목록 설정
	@ModelAttribute("conditionMap")
	public Map<String, String> searchConditionMap() {
		Map<String, String> conditionMap = new HashMap<String, String>();
		conditionMap.put("물품번호", "ITEM_NUM");
		conditionMap.put("물품이름", "ITEM_NAME");
		conditionMap.put("고객번호", "CUSTOMER_NUM");
		return conditionMap;
	}
	@RequestMapping("/insertItem.do")
	public String insertItem(ItemVO vo){
		itemService.insertItem(vo);
		return "getItemList.do";
	}
	@RequestMapping("/updateItem.do")
	public String updateItem(ItemVO vo){
		itemService.updateItem(vo);
		return "getItemList.do";
	}
	@RequestMapping("/deleteItem.do")
	public String deleteItem(ItemVO vo){
		itemService.deleteItem(vo);
		return "getItemList.do";
	}
	/*@RequestMapping("/getItem.do")
	public String getItem(ItemVO vo, Model model){
		model.addAttribute("customer", itemService.getItem(vo));
		return "getItem.jsp";
	}*/
	@RequestMapping("/getItemList.do")
	public String getItemList(ItemVO vo, Model model){
		// null check
		if(vo.getSearchCondition() == null) vo.setSearchCondition("ITEM_NUM");
		if(vo.getSearchKeyword() == null) vo.setSearchKeyword("");
		// model 정보저장
		model.addAttribute("itemList", itemService.getItemList(vo));
		return "getItemList.jsp";
	}
}
