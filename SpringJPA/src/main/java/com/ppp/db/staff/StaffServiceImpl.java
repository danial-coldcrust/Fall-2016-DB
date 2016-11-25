package com.ppp.db.staff;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("staffService")
public class StaffServiceImpl implements StaffService{
	@Autowired
	private StaffDAOJPA StaffDAO;
	
	public void insertStaff(StaffVO vo){
		StaffDAO.insertStaff(vo);
	}
	public void updateStaff(StaffVO vo) {
		StaffDAO.updateStaff(vo);
	}
	public void deleteStaff(StaffVO vo) {
		StaffDAO.deleteStaff(vo);
	}
	public StaffVO getStaff(StaffVO vo) {
		return StaffDAO.getStaff(vo);
	}
	public List<StaffVO> getStaffList(StaffVO vo) {
		return StaffDAO.getStaffList(vo);
	}
	
}
