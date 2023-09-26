package com.stationary.store.report.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.stationary.store.report.exception.StoreException;
import com.stationary.store.report.model.Item;
import com.stationary.store.report.service.HighestSellingItemService;

@RestController
public class HighestSellingItemImpl implements HighestSellingItem {
	@Autowired
	HighestSellingItemService highestSellingItemService;

	@GetMapping("/highestSellingItem/{date}")
	public ResponseEntity<Item> getHighestSellingItem(@PathVariable("date") String date) {
		try {
			return ResponseEntity.ok(highestSellingItemService.getHighestSellingItem(date));
		} catch (StoreException e) {
			return ResponseEntity.notFound().build();
		}
	}
}
