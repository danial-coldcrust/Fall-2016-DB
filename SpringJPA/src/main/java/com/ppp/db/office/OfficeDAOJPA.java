package com.ppp.db.office;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

@Repository
public class OfficeDAOJPA {
	@PersistenceContext
	private EntityManager em;
	
	public void insertOffice(OfficeVO vo){
		em.persist(vo);
	}
	public void updateOffice(OfficeVO vo){
		em.merge(vo);
	}
	public void deleteOffice(OfficeVO vo){
		em.remove(em.find(OfficeVO.class, vo.getOffice_num()));
	}
	public OfficeVO getOffice(OfficeVO vo){
		return (OfficeVO) em.find(OfficeVO.class, vo.getOffice_num());
	}
	public List<OfficeVO> getOfficeList(OfficeVO vo){
		if(vo.getSearchCondition().equals("OFFICE_NUM")){
			return em.createQuery("select b from OfficeVO b where b.office_num like '%'||?1||'%' order by b.office_num desc", OfficeVO.class).setParameter(1, vo.getSearchKeyword()).getResultList();
		}
		else if(vo.getSearchCondition().equals("OFFICE_NAME")){
			return em.createQuery("select b from OfficeVO b where b.office_name like '%'||?1||'%' order by b.office_num desc", OfficeVO.class).setParameter(1, vo.getSearchKeyword()).getResultList();
		}
		return null;
	}
}
