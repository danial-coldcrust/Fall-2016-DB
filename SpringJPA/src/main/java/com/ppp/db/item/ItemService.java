package com.ppp.db.item;

import java.util.List;

public interface ItemService {
	public void insertItem(ItemVO vo);
	public void updateItem(ItemVO vo);
	public void deleteItem(ItemVO vo);
	public ItemVO getItem(ItemVO vo);
	public List<ItemVO> getItemList(ItemVO vo);
}
