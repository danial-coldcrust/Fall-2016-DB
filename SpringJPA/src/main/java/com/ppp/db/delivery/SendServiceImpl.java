package com.ppp.db.delivery;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service("sendService")
public class SendServiceImpl implements SendService{
	@Autowired
	private SendDAOJPA sendDAO;
	
	public void insertSend(SendVO vo){
		sendDAO.insertSend(vo);
	}
	public void updateSend(SendVO vo){
		sendDAO.updateSend(vo);
	}
	public void deleteSend(SendVO vo){
		sendDAO.deleteSend(vo);
	}
	public SendVO getSend(SendVO vo){
		return sendDAO.getSend(vo);
	}
	public List<SendVO> getSendList(SendVO vo){
		return sendDAO.getSendList(vo);
	}
}
