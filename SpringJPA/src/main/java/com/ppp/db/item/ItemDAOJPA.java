package com.ppp.db.item;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
@Repository
public class ItemDAOJPA {
	@PersistenceContext
	private EntityManager em;
	
	public void insertItem(ItemVO vo){
		em.persist(vo);
	}
	public void updateItem(ItemVO vo){
		em.merge(vo);
	}
	public void deleteItem(ItemVO vo){
		em.remove(em.find(ItemVO.class, vo.getItem_num()));
	}
	public ItemVO getItem(ItemVO vo){
		return (ItemVO) em.find(ItemVO.class, vo.getItem_num());
	}
	public List<ItemVO> getItemList(ItemVO vo){
		if(vo.getSearchCondition().equals("item_num")){
			return em.createQuery("select b from ItemVO b where b.item_num like '%'||?1||'%' order by b.item_num desc", ItemVO.class).setParameter(1, vo.getSearchKeyword()).getResultList();
		}
		else if(vo.getSearchCondition().equals("item_name")){
			return em.createQuery("select b from ItemVO b where b.item_name like '%'||?1||'%' order by b.item_num desc", ItemVO.class).setParameter(1, vo.getSearchKeyword()).getResultList();
		}
		else if(vo.getSearchCondition().equals("customer_num")){
			return em.createQuery("select b from ItemVO b where b.customer_num like '%'||?1||'%' order by b.item_num desc", ItemVO.class).setParameter(1, vo.getSearchKeyword()).getResultList();
		}
		return null;
	}
}
