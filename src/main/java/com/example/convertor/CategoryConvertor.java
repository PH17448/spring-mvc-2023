package com.example.convertor;

import org.springframework.stereotype.Component;

import com.example.dto.CategoryDTO;
import com.example.entity.CategoryEntity;

@Component
public class CategoryConvertor {
	public CategoryEntity toEntity(CategoryDTO newDto) {
		CategoryEntity entity = new CategoryEntity();
		
		
		
		entity.setCode(newDto.getCode());
		entity.setName(newDto.getName());
		
		return entity ;
	}
	public CategoryDTO toDTO(CategoryEntity newEntity) {
		CategoryDTO dto = new CategoryDTO();
		if(newEntity.getId() != null) {
			dto.setId(newEntity.getId());
		}
		dto.setCode(newEntity.getCode());
		dto.setName(newEntity.getName());
		return dto ;
	}
}
