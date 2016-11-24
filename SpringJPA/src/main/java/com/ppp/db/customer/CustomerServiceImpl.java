package com.ppp.db.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService{
	@Autowired
	private CustomerDAOJPA CustomerDAO;
	
	public void insertCustomer(CustomerVO vo){
		CustomerDAO.insertCustomer(vo);
	}
	public void updateCustomer(CustomerVO vo) {
		CustomerDAO.updateCustomer(vo);
	}
	public void deleteCustomer(CustomerVO vo) {
		CustomerDAO.deleteCustomer(vo);
	}
	public CustomerVO getCustomer(CustomerVO vo) {
		return CustomerDAO.getCustomer(vo);
	}
	public List<CustomerVO> getCustomerList(CustomerVO vo) {
		return CustomerDAO.getCustomerList(vo);
	}
}
