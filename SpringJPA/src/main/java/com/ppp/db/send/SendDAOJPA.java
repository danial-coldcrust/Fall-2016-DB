package com.ppp.db.send;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
@Repository
public class SendDAOJPA {
	@PersistenceContext
	private EntityManager em;

	public void insertSend(SendVO vo) {
		em.persist(vo);
	}

	public void updateSend(SendVO vo) {
		em.merge(vo);
	}

	public void deleteSend(SendVO vo) {
		em.remove(em.find(SendVO.class, vo.getSend_num()));
	}

	public SendVO getSend(SendVO vo) {
		return (SendVO) em.find(SendVO.class, vo.getSend_num());
	}
	
	public List<SendVO> getSendList(SendVO vo) {
		if (vo.getSearchCondition().equals("SEND_NUM")) {
			return em.createQuery("select b from SendVO b where b.send_num like '%'||?1||'%' order by b.send_num desc",
					SendVO.class).setParameter(1, vo.getSearchKeyword()).getResultList();
		} else if (vo.getSearchCondition().equals("ITEM_NUM")) {
			return em.createQuery("select b from SendVO b where b.item_num like '%'||?1||'%' order by b.send_num desc",
					SendVO.class).setParameter(1, vo.getSearchKeyword()).getResultList();
		} else if (vo.getSearchCondition().equals("STAFF_NUM")) {
			return em.createQuery("select b from SendVO b where b.staff_num like '%'||?1||'%' order by b.send_num desc",
					SendVO.class).setParameter(1, vo.getSearchKeyword()).getResultList();
		} else if (vo.getSearchCondition().equals("DATE")) {
			return em.createQuery("select b from SendVO b where b.date like '%'||?1||'%' order by b.send_num desc",
					SendVO.class).setParameter(1, vo.getSearchKeyword()).getResultList();
		} else if (vo.getSearchCondition().equals("TIME")) {
			return em.createQuery("select b from SendVO b where b.time like '%'||?1||'%' order by b.send_num desc",
					SendVO.class).setParameter(1, vo.getSearchKeyword()).getResultList();
		} else if (vo.getSearchCondition().equals("ITEM_POSITION")) {
			return em.createQuery(
					"select b from SendVO b where b.item_position like '%'||?1||'%' order by b.send_num desc",
					SendVO.class).setParameter(1, vo.getSearchKeyword()).getResultList();
		} else if (vo.getSearchCondition().equals("HANDLING_STATE")) {
			return em.createQuery(
					"select b from SendVO b where b.handling_state like '%'||?1||'%' order by b.send_num desc",
					SendVO.class).setParameter(1, vo.getSearchKeyword()).getResultList();
		} else if (vo.getSearchCondition().equals("RECEIVER_NAME")) {
			return em.createQuery(
					"select b from SendVO b where b.receiver_name like '%'||?1||'%' order by b.send_num desc",
					SendVO.class).setParameter(1, vo.getSearchKeyword()).getResultList();
		}
		return null;
	}
}
