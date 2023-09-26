package com.stationary.store.report.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stationary.store.report.dao.HighestSellingItemDao;
import com.stationary.store.report.dao.dto.ItemDto;
import com.stationary.store.report.model.Item;

@Service
public class HighestSellingItemServiceImpl implements HighestSellingItemService {
	@Autowired
	HighestSellingItemDao highestSellingItemDao;
	
	public Item getHighestSellingItem(String date) {
		
		ItemDto itemDto =  highestSellingItemDao.getHighestSellingItem(date);
		return new Item(itemDto.getProduct(), itemDto.getCount());
	}

}
