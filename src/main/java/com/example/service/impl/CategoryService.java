package com.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.ICategoryDAO;
import com.example.dto.CategoryDTO;
import com.example.service.ICategoryService;


@Service
public class CategoryService implements ICategoryService {

	@Autowired
	private ICategoryDAO categoryDao ;
	
	
	public List<CategoryDTO> findAll() {
		return categoryDao.findAll();
	}

}
