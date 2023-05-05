package com.example.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.convertor.NewConvertor;
import com.example.dto.NewsDTO;
import com.example.entity.NewEntity;
import com.example.repository.NewRepository;
import com.example.service.INewService;


@Service
public class NewService implements INewService {
	
	@Autowired
	private NewRepository newRepo ;
	
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

	
	
}
