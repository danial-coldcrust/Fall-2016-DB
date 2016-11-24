package com.ppp.db.customer;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

@Repository
public class CustomerDAOJPA {
	@PersistenceContext
	private EntityManager em;
	
	public void insertCustomer(CustomerVO vo){
		em.persist(vo);
	}
	public void updateCustomer(CustomerVO vo){
		em.merge(vo);
	}
	public void deleteCustomer(CustomerVO vo){
		em.remove(em.find(CustomerVO.class, vo.getCustomer_num()));
	}
	public CustomerVO getCustomer(CustomerVO vo){
		return (CustomerVO) em.find(CustomerVO.class, vo.getCustomer_num());
	}
	public List<CustomerVO> getCustomerList(CustomerVO vo){
		return em.createQuery("select b from CustomerVO b order by b.customer_num desc", CustomerVO.class).getResultList();
	}

}
