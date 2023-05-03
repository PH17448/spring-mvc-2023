package com.example.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.dao.INewDAO;
import com.example.dto.NewsDTO;
import com.example.mappper.NewMapper;


@Repository
public class NewDAO extends AbstractDAO<NewsDTO> implements INewDAO {
	
	
	

	@Override
	public List<NewsDTO> findAll() {
//		String sql = "SELECT * FROM news LIMIT ?, ?";
		StringBuilder sql = new StringBuilder("SELECT * FROM news");
		return query(sql.toString(),new NewMapper());
	}

	

}
