package com.example.dao;

import java.util.List;

import com.example.mappper.RowMapper;


public interface IGenericDAO<EntityKey> {
	 public  List<EntityKey> query(String sql,RowMapper<EntityKey> rowMapper ,Object... paramater);
	 public void update(String sql , Object... parameter);
	 public Long insert(String sql ,Object... parameter );
	 int count(String sql,Object... parameter);
}
