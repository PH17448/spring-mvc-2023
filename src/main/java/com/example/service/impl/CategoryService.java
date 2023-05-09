package com.example.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.CategoryEntity;
import com.example.repository.CategoryRepository;
import com.example.service.ICategoryService;


@Service
public class CategoryService implements ICategoryService {

	@Autowired
	private CategoryRepository cateRepo ;

	@Override
	public Map<String, String> findAll() {
		Map<String,String> result = new HashMap<>();
		List<CategoryEntity> entities = cateRepo.findAll();
		for(CategoryEntity entity : entities) {
			result.put(entity.getCode(),entity.getName());
		}
		return result;
	}
	
	
	
	
	

}
