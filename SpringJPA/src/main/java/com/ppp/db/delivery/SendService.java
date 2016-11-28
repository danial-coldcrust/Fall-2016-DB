package com.ppp.db.delivery;

import java.util.List;

public interface SendService {
	public void insertSend(SendVO vo);
	public void updateSend(SendVO vo);
	public void deleteSend(SendVO vo);
	public SendVO getSend(SendVO vo);
	public List<SendVO> getSendList(SendVO vo);
}
