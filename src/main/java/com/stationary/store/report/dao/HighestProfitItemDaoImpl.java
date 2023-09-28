package com.stationary.store.report.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.stationary.store.report.dao.dto.ItemDto;
import com.stationary.store.report.dao.mapper.ItempProfitRowMapper;
import com.stationary.store.report.exception.StoreException;

@Repository
public class HighestProfitItemDaoImpl implements HighestProfitItemDao{
	
	private static final String MAX_PROFIT_SQL = "SELECT PRODUCT, MAX(PROFIT) AS MAX_PROFIT FROM SALES WHERE ORDER_DATE=? GROUP BY PRODUCT ORDER BY  MAX_PROFIT DESC LIMIT 1";
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public ItemDto getHighestProfitItem(String date) {
		
		try {
			return jdbcTemplate.queryForObject(MAX_PROFIT_SQL, new ItempProfitRowMapper(), date);
		} catch (DataAccessException e) {
			throw new StoreException(e);
		}
	}

}
