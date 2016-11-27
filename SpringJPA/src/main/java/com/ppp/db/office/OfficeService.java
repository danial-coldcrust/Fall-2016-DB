package com.ppp.db.office;

import java.util.List;

public interface OfficeService {
	public void insertOffice(OfficeVO vo);
	public void updateOffice(OfficeVO vo);
	public void deleteOffice(OfficeVO vo);
	public OfficeVO getOffice(OfficeVO vo);
	public List<OfficeVO> getOfficeList(OfficeVO vo);
}
