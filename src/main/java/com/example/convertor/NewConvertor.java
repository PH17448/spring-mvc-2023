package com.example.convertor;

import org.springframework.stereotype.Component;

import com.example.dto.NewsDTO;
import com.example.entity.NewEntity;


@Component
public class NewConvertor {
	
	public NewEntity toEntity(NewsDTO newDto) {
		NewEntity entity = new NewEntity();
		entity.setTitle(newDto.getTitle());
		entity.setContent(newDto.getContent());
		entity.setShortDescription(newDto.getShortDescription());
		entity.setThumbnail(newDto.getThumbnail());
		return entity ;
	}
	
	public NewsDTO toDTO(NewEntity newEntity) {
		NewsDTO newDto = new NewsDTO();
		if(newEntity.getId() != null) {
			newDto.setId(newEntity.getId());
		}
		newDto.setTitle(newEntity.getTitle());
		newDto.setContent(newEntity.getContent());
		newDto.setThumbnail(newEntity.getThumbnail());
		newDto.setShortDescription(newEntity.getShortDescription());
		newDto.setCategoryCode(newEntity.getCategory().getCode());
		newDto.setCreatedDate(newEntity.getCreatedDate());
		newDto.setCreatedBy(newEntity.getCreatedBy());
		newDto.setModifiedDate(newEntity.getModifiedDate());
		newDto.setModifiedBy(newEntity.getModifiedBy());
		return newDto ;
	}
	
	public NewEntity toEntity( NewsDTO newDto , NewEntity oldNewEntity) {
		
		oldNewEntity.setTitle(newDto.getTitle());
		oldNewEntity.setContent(newDto.getContent());
		oldNewEntity.setThumbnail(newDto.getThumbnail());
		oldNewEntity.setShortDescription(newDto.getShortDescription());
		
		return oldNewEntity ;
	}
	
}
