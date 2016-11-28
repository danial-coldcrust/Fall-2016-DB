package com.ppp.db.receipt;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class ReceiptDAOJPA {
	@PersistenceContext
	private EntityManager em;

	public void insertReceipt(ReceiptVO vo) {
		em.persist(vo);
	}

	public void updateReceipt(ReceiptVO vo) {
		em.merge(vo);
	}

	public void deleteReceipt(ReceiptVO vo) {
		em.remove(em.find(ReceiptVO.class, vo.getReceipt_num()));
	}

	public ReceiptVO getReceipt(ReceiptVO vo) {
		return (ReceiptVO) em.find(ReceiptVO.class, vo.getReceipt_num());
	}

	public List<ReceiptVO> getReceiptList(ReceiptVO vo) {
		if (vo.getSearchCondition().equals("receipt_num")) {
			return em.createQuery(
					"select b from ReceiptVO b where b.receipt_num like '%'||?1||'%' order by b.receipt_num desc",
					ReceiptVO.class).setParameter(1, vo.getSearchKeyword()).getResultList();
		} else if (vo.getSearchCondition().equals("customer_num")) {
			return em.createQuery(
					"select b from ReceiptVO b where b.customer_num like '%'||?1||'%' order by b.receipt_num desc",
					ReceiptVO.class).setParameter(1, vo.getSearchKeyword()).getResultList();
		} else if (vo.getSearchCondition().equals("item_num")) {
			return em.createQuery(
					"select b from ReceiptVO b where b.item_num like '%'||?1||'%' order by b.receipt_num desc",
					ReceiptVO.class).setParameter(1, vo.getSearchKeyword()).getResultList();
		} else if (vo.getSearchCondition().equals("staff_num")) {
			return em.createQuery(
					"select b from ReceiptVO b where b.staff_num like '%'||?1||'%' order by b.receipt_num desc",
					ReceiptVO.class).setParameter(1, vo.getSearchKeyword()).getResultList();
		} else if (vo.getSearchCondition().equals("receipt_date")) {
			return em.createQuery(
					"select b from ReceiptVO b where b.receipt_date like '%'||?1||'%' order by b.receipt_num desc",
					ReceiptVO.class).setParameter(1, vo.getSearchKeyword()).getResultList();
		} else if (vo.getSearchCondition().equals("send_type")) {
			return em.createQuery(
					"select b from ReceiptVO b where b.send_type like '%'||?1||'%' order by b.receipt_num desc",
					ReceiptVO.class).setParameter(1, vo.getSearchKeyword()).getResultList();
		} else if (vo.getSearchCondition().equals("pay_type")) {
			return em.createQuery(
					"select b from ReceiptVO b where b.pay_type like '%'||?1||'%' order by b.receipt_num desc",
					ReceiptVO.class).setParameter(1, vo.getSearchKeyword()).getResultList();
		} else if (vo.getSearchCondition().equals("send_pay")) {
			return em.createQuery(
					"select b from ReceiptVO b where b.send_pay like '%'||?1||'%' order by b.receipt_num desc",
					ReceiptVO.class).setParameter(1, vo.getSearchKeyword()).getResultList();
		}
		return null;
	}
}
