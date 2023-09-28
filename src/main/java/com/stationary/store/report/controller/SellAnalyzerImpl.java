package com.stationary.store.report.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.stationary.store.report.exception.StoreException;
import com.stationary.store.report.model.Item;
import com.stationary.store.report.service.HighestProfitItemService;
import com.stationary.store.report.service.HighestSellingItemService;

@RestController
public class SellAnalyzerImpl implements SellAnalyzer {
	@Autowired
	HighestSellingItemService highestSellingItemService;

	@Autowired
	HighestProfitItemService highestProfitItemService;

	@GetMapping("/highestSellingItem/{date}")
	public ResponseEntity<Item> getHighestSellingItem(@PathVariable("date") String date) {
		try {
			return ResponseEntity.ok(highestSellingItemService.getHighestSellingItem(date));
		} catch (StoreException e) {
			return ResponseEntity.notFound().build();
		}
	}

	@Override
	@GetMapping("/highestProfitItem/{date}")
	public ResponseEntity<Item> getHighestProfitItem(@PathVariable("date") String date) {
		try {
			return ResponseEntity.ok(highestProfitItemService.getHighestProfitItem(date));
		} catch (StoreException e) {
			return ResponseEntity.notFound().build();
		}
	}
}
