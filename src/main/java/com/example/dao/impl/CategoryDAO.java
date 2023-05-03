package com.example.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.dao.ICategoryDAO;
import com.example.dto.CategoryDTO;
import com.example.mappper.CategoryMapper;


@Repository
public class CategoryDAO extends AbstractDAO<CategoryDTO> implements ICategoryDAO {

	
	@Override
	public List<CategoryDTO> findAll() {
		String sql = "SELECT * FROM category";
		return query(sql, new CategoryMapper());
	}

	@Override
	public CategoryDTO findOne(Long id) {
		String sql = "SELECT * FROM category WHERE id=?";
		List<CategoryDTO> list = query(sql, new CategoryMapper(), id);
		return list.isEmpty() ? null : list.get(0);
	}

	@Override
	public CategoryDTO findOneByCode(String categoryCode) {
		String sql = "SELECT * FROM category WHERE code=?";
		List<CategoryDTO> list = query(sql, new CategoryMapper(), categoryCode);
		return list.isEmpty() ? null : list.get(0);
	}

}
