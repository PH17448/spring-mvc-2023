package com.example.dao;

import java.util.List;

import com.example.dto.NewsDTO;

public interface INewDAO extends IGenericDAO<NewsDTO>  {
	List<NewsDTO> findAll();
}
