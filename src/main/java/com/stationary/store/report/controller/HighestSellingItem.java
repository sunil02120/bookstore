package com.stationary.store.report.controller;

import org.springframework.http.ResponseEntity;

import com.stationary.store.report.model.Item;

public interface HighestSellingItem {
	
	ResponseEntity<Item> getHighestSellingItem(String date);

}
