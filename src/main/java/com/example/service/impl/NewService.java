package com.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.INewDAO;
import com.example.dto.NewsDTO;
import com.example.service.INewService;


@Service
public class NewService implements INewService {
	
	@Autowired
	private INewDAO newsDao ;
	

	@Override
	public List<NewsDTO> findAll() {
		return newsDao.findAll();
	}

	
	
}
