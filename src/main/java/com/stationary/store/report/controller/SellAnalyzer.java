package com.stationary.store.report.controller;

import org.springframework.http.ResponseEntity;

import com.stationary.store.report.model.Item;

public interface SellAnalyzer {
	
	ResponseEntity<Item> getHighestSellingItem(String date);
	
	ResponseEntity<Item> getHighestProfitItem(String date);

}
