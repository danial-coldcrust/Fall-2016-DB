package com.ppp.db.office;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("officeService")
public class OfficeServiceImpl implements OfficeService {
	@Autowired
	private OfficeDAOJPA officeDAO;
	
	public void insertOffice(OfficeVO vo){
		officeDAO.insertOffice(vo);
	}
	public void updateOffice(OfficeVO vo){
		officeDAO.updateOffice(vo);
	}
	public void deleteOffice(OfficeVO vo){
		officeDAO.deleteOffice(vo);
	}
	public OfficeVO getOffice(OfficeVO vo){
		return officeDAO.getOffice(vo);
	}
	public List<OfficeVO> getOfficeList(OfficeVO vo){
		return officeDAO.getOfficeList(vo);
	}

}
