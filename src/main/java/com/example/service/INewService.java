package com.example.service;

import java.util.List;

import com.example.dto.NewsDTO;


public interface INewService {
	List<NewsDTO> findAll();
}
