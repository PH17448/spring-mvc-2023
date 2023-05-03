package com.example.mappper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.dto.CategoryDTO;


public class CategoryMapper implements RowMapper<CategoryDTO> {

	public CategoryDTO MapRow(ResultSet result) {
		try {
			CategoryDTO category = new CategoryDTO();
			category.setId(result.getLong("id"));
			category.setName(result.getString("name"));
			category.setCode(result.getString("code"));
			return category ;
		}catch(SQLException e) {
			return null ;
		}
	}

}
