package com.example.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.example.dto.NewsDTO;


public interface INewService {
	List<NewsDTO> findAll(Pageable pageable);
	int getTotalItem();
}
