package com.stationary.store.report.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stationary.store.report.dao.HighestProfitItemDao;
import com.stationary.store.report.dao.dto.ItemDto;
import com.stationary.store.report.model.Item;

@Service
public class HighestProfitItemServiceImpl implements HighestProfitItemService {
	@Autowired
	HighestProfitItemDao highestProfitItemDao;
	
	public Item getHighestProfitItem(String date) {
		
		ItemDto itemDto =  highestProfitItemDao.getHighestProfitItem(date);
		return new Item(itemDto.getProduct(), itemDto.getCount());
	}

}
