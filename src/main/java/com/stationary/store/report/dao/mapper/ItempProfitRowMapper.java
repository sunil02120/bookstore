package com.stationary.store.report.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.stationary.store.report.dao.dto.ItemDto;

public class ItempProfitRowMapper implements RowMapper<ItemDto> {

	public ItemDto mapRow(ResultSet rs, int rowNum) throws SQLException {

		return new ItemDto(rs.getString("PRODUCT"), rs.getInt("MAX_PROFIT"));

	}
}
