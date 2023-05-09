package com.example.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.convertor.NewConvertor;
import com.example.dto.NewsDTO;
import com.example.entity.CategoryEntity;
import com.example.entity.NewEntity;
import com.example.repository.CategoryRepository;
import com.example.repository.NewRepository;
import com.example.service.INewService;


@Service
public class NewService implements INewService {
	
	@Autowired
	private NewRepository newRepo ;
	
	@Autowired
	private CategoryRepository cateRepo ;
	
	@Autowired
	private NewConvertor newConvertor ;

	@Override
	public List<NewsDTO> findAll(Pageable pageable) {
		List<NewsDTO> listNewDTO = new ArrayList<>();
		List<NewEntity> entities =  newRepo.findAll(pageable).getContent();
		for(NewEntity item : entities) {
			NewsDTO newDto = newConvertor.toDTO(item);
			listNewDTO.add(newDto);
		}
		return listNewDTO;
	}


	@Override
	public int getTotalItem() {
		return (int) newRepo.count();
	}


	@Override
	public NewsDTO findById(long id) {
		NewEntity entity = newRepo.findOne(id);
		NewsDTO dto = newConvertor.toDTO(entity);
		return dto;
	}


	@Override
	@Transactional
	public NewsDTO save(NewsDTO newDto) {
		CategoryEntity category = cateRepo.findOneByCode(newDto.getCategoryCode());
		NewEntity newEntity = new NewEntity();
		if(newDto.getId() != null) {
			NewEntity oldNew = newRepo.findOne(newDto.getId());
			newEntity = newConvertor.toEntity(newDto,oldNew);
		}else {
			newEntity = newConvertor.toEntity(newDto);
		}
		newEntity.setCategory(category);
		newEntity = newRepo.save(newEntity);
		return newConvertor.toDTO(newEntity);
	}


	@Override
	@Transactional
	public void delete(long[] ids) {
		for (long id : ids) {
			newRepo.delete(id);
		}
	}

	
	
}
