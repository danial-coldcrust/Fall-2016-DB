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
		if(vo.getSearchCondition().equals("CUSTOMER_NUM")){
			return em.createQuery("select b from CustomerVO b where b.customer_num like '%'||?1||'%' order by b.customer_num desc", CustomerVO.class).setParameter(1, vo.getSearchKeyword()).getResultList();
		}
		else if(vo.getSearchCondition().equals("CUSTOMER_NAME")){
			return em.createQuery("select b from CustomerVO b where b.customer_name like '%'||?1||'%' order by b.customer_num desc", CustomerVO.class).setParameter(1, vo.getSearchKeyword()).getResultList();
		}
		else if(vo.getSearchCondition().equals("CUSTOMER_PHONENUM")){
			return em.createQuery("select b from CustomerVO b where b.customer_phonenum like '%'||?1||'%' order by b.customer_num desc", CustomerVO.class).setParameter(1, vo.getSearchKeyword()).getResultList();
		}
		return null;
		// 위에서 검색조건에 따른 쿼리문 설정으로 아래껀 필요없어짐 ^^ 검색조건에 따른거 설정하기전엔 아래처럼 사용...
		//return em.createQuery("select b from CustomerVO b order by b.customer_num desc", CustomerVO.class).getResultList();
	}

}
