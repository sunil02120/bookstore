package com.stationary.store.report.dao;

import com.stationary.store.report.dao.dto.ItemDto;

public interface HighestProfitItemDao {
	ItemDto getHighestProfitItem(String date);
}
