package com.ppp.db.staff;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

@Repository
public class StaffDAOJPA {
	@PersistenceContext
	private EntityManager em;
	
	public void insertStaff(StaffVO vo){
		em.persist(vo);
	}
	public void updateStaff(StaffVO vo){
		em.merge(vo);
	}
	public void deleteStaff(StaffVO vo){
		em.remove(em.find(StaffVO.class, vo.getStaff_num()));
	}
	public StaffVO getStaff(StaffVO vo){
		return (StaffVO) em.find(StaffVO.class, vo.getStaff_num());
	}
	public List<StaffVO> getStaffList(StaffVO vo){
		if(vo.getSearchCondition().equals("STAFF_NUM")){
			return em.createQuery("select b from StaffVO b where b.staff_num like '%'||?1||'%' order by b.staff_num desc", StaffVO.class).setParameter(1, vo.getSearchKeyword()).getResultList();
		}
		else if(vo.getSearchCondition().equals("OFFICE_NUM")){
			return em.createQuery("select b from StaffVO b where b.office_num like '%'||?1||'%' order by b.staff_num desc", StaffVO.class).setParameter(1, vo.getSearchKeyword()).getResultList();
		}
		else if(vo.getSearchCondition().equals("STAFF_JOB")){
			return em.createQuery("select b from StaffVO b where b.staff_job like '%'||?1||'%' order by b.staff_num desc", StaffVO.class).setParameter(1, vo.getSearchKeyword()).getResultList();
		}
		else if(vo.getSearchCondition().equals("STAFF_NAME")){
			return em.createQuery("select b from StaffVO b where b.staff_name like '%'||?1||'%' order by b.staff_num desc", StaffVO.class).setParameter(1, vo.getSearchKeyword()).getResultList();
		}
		else if(vo.getSearchCondition().equals("STAFF_PHONENUM")){
			return em.createQuery("select b from StaffVO b where b.staff_phonenum like '%'||?1||'%' order by b.staff_num desc", StaffVO.class).setParameter(1, vo.getSearchKeyword()).getResultList();
		}
		return null;
	}
	
}
