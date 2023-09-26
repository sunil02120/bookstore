package com.stationary.store.report.service;

import com.stationary.store.report.model.Item;

public interface HighestSellingItemService {
	
	Item getHighestSellingItem(String date);

}
