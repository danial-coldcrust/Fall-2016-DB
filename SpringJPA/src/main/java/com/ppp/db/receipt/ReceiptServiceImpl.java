package com.ppp.db.receipt;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("receiptService")
public class ReceiptServiceImpl implements ReceiptService {
	@Autowired
	private ReceiptDAOJPA receiptDAO;

	public void insertReceipt(ReceiptVO vo) {
		receiptDAO.insertReceipt(vo);
	}

	public void updateReceipt(ReceiptVO vo) {
		receiptDAO.updateReceipt(vo);
	}

	public void deleteReceipt(ReceiptVO vo) {
		receiptDAO.deleteReceipt(vo);
	}

	public ReceiptVO getReceipt(ReceiptVO vo) {
		return receiptDAO.getReceipt(vo);
	}

	public List<ReceiptVO> getReceiptList(ReceiptVO vo) {
		return receiptDAO.getReceiptList(vo);
	}

}
