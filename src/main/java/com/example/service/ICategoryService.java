package com.example.service;

import java.util.List;

import com.example.dto.CategoryDTO;


public interface ICategoryService {
	List<CategoryDTO> findAll();
}
