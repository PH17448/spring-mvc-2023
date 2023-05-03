package com.example.dao;

import java.util.List;

import com.example.dto.CategoryDTO;


public interface ICategoryDAO extends IGenericDAO<CategoryDTO> {
	public List<CategoryDTO> findAll();
	public CategoryDTO findOne(Long id);
	public CategoryDTO findOneByCode(String categoryCode);
}
