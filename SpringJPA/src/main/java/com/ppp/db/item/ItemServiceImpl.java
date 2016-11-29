package com.ppp.db.item;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("itemService")
public class ItemServiceImpl implements ItemService{
	@Autowired
	private ItemDAOJPA itemDAO;
	
	public void insertItem(ItemVO vo){
		itemDAO.insertItem(vo);
	}
	public void updateItem(ItemVO vo){
		itemDAO.updateItem(vo);
	}
	public void deleteItem(ItemVO vo){
		itemDAO.deleteItem(vo);
	}
	public ItemVO getItem(ItemVO vo){
		return itemDAO.getItem(vo);
	}
	public List<ItemVO> getItemList(ItemVO vo) {
		return itemDAO.getItemList(vo);
	}
}
