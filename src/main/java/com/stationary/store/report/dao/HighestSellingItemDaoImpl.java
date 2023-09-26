package com.stationary.store.report.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.stationary.store.report.dao.dto.ItemDto;
import com.stationary.store.report.dao.mapper.ItemRowMapper;
import com.stationary.store.report.exception.StoreException;

@Repository
public class HighestSellingItemDaoImpl implements HighestSellingItemDao{
	
	private static final String MAX_SALE_SQL = "SELECT  PRODUCT, MAX(SALE_COUNT) AS MAX_SALE FROM SALES WHERE ORDER_DATE = ? GROUP BY SALE_COUNT ORDER BY  MAX_SALE  DESC LIMIT 1";
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public ItemDto getHighestSellingItem(String date) {
		
		try {
			return jdbcTemplate.queryForObject(MAX_SALE_SQL, new ItemRowMapper(), date);
		} catch (DataAccessException e) {
			throw new StoreException(e);
		}
	}

}
