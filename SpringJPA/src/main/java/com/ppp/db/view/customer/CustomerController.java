package com.ppp.db.view.customer;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ppp.db.customer.CustomerService;
import com.ppp.db.customer.CustomerVO;

@Controller
@SessionAttributes("customer")
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	
	//검색 조건 목록 설정
	@ModelAttribute("conditionMap")
	public Map<String, String> searchConditionMap(){
		Map<String, String> conditionMap = new HashMap<String, String>();
		conditionMap.put("고객번호", "CUSTOMER_NUM");
		conditionMap.put("고객이름", "CUSTOMER_NAME");
		conditionMap.put("전화번호", "CUSTOMER_PHONENUM");
		return conditionMap;
	}
	
	@RequestMapping("/insertCustomer.do")
	public String insertCustomer(CustomerVO vo){
		customerService.insertCustomer(vo);
		return "getCustomerList.do";
	}
	
	@RequestMapping("/updateCustomer.do")
	public String updateCustomer(@ModelAttribute("customer") CustomerVO vo){
		customerService.updateCustomer(vo);
		return "getCustomerList.do";
	}
	
	@RequestMapping("/deleteCustomer.do")
	public String deleteCustomer(CustomerVO vo){
		customerService.deleteCustomer(vo);
		return "getCustomerList.do";
	}
	
	@RequestMapping("/getCustomer.do")
	public String getCustomer(CustomerVO vo, Model model){
		model.addAttribute("customer", customerService.getCustomer(vo));
		return "getCustomer.jsp";
	}
	
	@RequestMapping("/getCustomerList.do")
	public String getCustomerList(@RequestParam(value="searchCondition",
			defaultValue="customer_num", required=false) String condition,
			@RequestParam(value="searchKeyword", defaultValue="", required=false)
			String keyword, CustomerVO vo, Model model){
		model.addAttribute("customerList", customerService.getCustomerList(vo));
		return "getCustomerList.jsp";
	}
}
