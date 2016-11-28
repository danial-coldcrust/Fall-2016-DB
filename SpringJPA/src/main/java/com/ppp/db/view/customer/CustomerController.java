package com.ppp.db.view.customer;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
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
	/*updateCustomer에서는 @ModelAttribute("customer") 로 써야할것같은데 ?..
		@ModelAttribute로 하거나 없애면 잘돌아가네 ?
		customer로 되어있을땐 jsp에서 수정이 안됐음	
	*/
	@RequestMapping("/updateCustomer.do")
	public String updateCustomer(CustomerVO vo){
		customerService.updateCustomer(vo);
		return "getCustomerList.do";
	}
	
	@RequestMapping("/deleteCustomer.do")
	public String deleteCustomer(CustomerVO vo){
		customerService.deleteCustomer(vo);
		return "getCustomerList.do";
	}
	/*
	한페이지에서 추가/삭제/검색/수정 구현해서 필요없어짐
	@RequestMapping("/getCustomer.do")
	public String getCustomer(CustomerVO vo, Model model){
		model.addAttribute("customer", customerService.getCustomer(vo));
		return "getCustomer.jsp";
	}
	*/
	/*getCustomerList설정 시CustomerVO에 searchKeyword, searchCondition 변수없으면 매개변수에 
	@RequestParam(value="searchCondition",
	defaultValue="customer_num", required=false) String condition,
	@RequestParam(value="searchKeyword", defaultValue="", required=false)
	String keyword,  추가*/
	@RequestMapping("/getCustomerList.do")
	public String getCustomerList(CustomerVO vo, Model model){
		// null check
		if(vo.getSearchCondition() == null) vo.setSearchCondition("CUSTOMER_NUM");
		if(vo.getSearchKeyword() == null) vo.setSearchKeyword("");
		// model 정보저장
		model.addAttribute("customerList", customerService.getCustomerList(vo));
		return "getCustomerList.jsp";
	}
	
	/*로그인 시작*/
	// 허상인가?... get,post따로 지정해야한다했는데 잘됨
		/*@RequestMapping(value="/customerLogin.do", method=RequestMethod.GET)
		public String loingView(CustomerVO vo){
			return "customerLogin.jsp";
		}*/
		/*@RequestMapping(value="/customerLogin.do", method=RequestMethod.POST)
		public String loing(CustomerVO vo){
			if(customerService.getCustomer(vo) != null) return "getCustomerList.do";
			else return "customerLogin.jsp";
		}*/
	@RequestMapping("/customerLogin.do")
	public String loing(CustomerVO vo,HttpSession session){
		if(customerService.getCustomer(vo) != null){
			//getCustomer는 customer_num로 비교해서 가져옴 그러므로 전화번호를 비교하는 구문이 필요
			CustomerVO customer = customerService.getCustomer(vo);
			session.setAttribute("c_name",customer.getCustomer_name());
			// 패스워드와 전화번호가 동일한지 비교하는 조건식
			if(vo.getCustomer_phonenum().equals(
					customer.getCustomer_phonenum()))
				return "getCustomerList.do";
			else
				return "customerLogin.jsp";
		}
		else return "customerLogin.jsp";
	}
	@RequestMapping("/customerLogOut.do")
	public String logout(HttpSession session){
		session.invalidate();
		return "customerLogin.jsp";
	}
	/*로그인 종료*/
	
}
