package com.ppp.db.staff;

import java.util.List;

public interface StaffService {
	public void insertStaff(StaffVO vo);
	public void updateStaff(StaffVO vo);
	public void deleteStaff(StaffVO vo);
	public StaffVO getStaff(StaffVO vo);
	public List<StaffVO> getStaffList(StaffVO vo);
}
