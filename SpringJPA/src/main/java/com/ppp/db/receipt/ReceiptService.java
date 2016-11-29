package com.ppp.db.receipt;

import java.util.List;

public interface ReceiptService {
	public void insertReceipt(ReceiptVO vo);
	public void updateReceipt(ReceiptVO vo);
	public void deleteReceipt(ReceiptVO vo);
	public ReceiptVO getReceipt(ReceiptVO vo);
	public List<ReceiptVO> getReceiptList(ReceiptVO vo);
}
