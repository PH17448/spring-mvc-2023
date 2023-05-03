package com.example.mappper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.dto.NewsDTO;


public class NewMapper implements RowMapper<NewsDTO> {

	public NewsDTO MapRow(ResultSet result) {
		try {
			NewsDTO news = new NewsDTO();
			news.setId(result.getLong("id"));
			news.setThumbnail(result.getString("thumbnail"));
			news.setTitle(result.getString("title"));
			news.setContent(result.getString("content"));
			news.setShortDescription(result.getString("shortdescription"));
			news.setCreatedDate(result.getTimestamp("createdDate"));
			news.setCreatedBy(result.getString("createBy"));
			news.setCategoryId(result.getLong("categoryid"));
			if(result.getTimestamp("modifiedDate") != null) {
				news.setModifiedDate(result.getTimestamp("modifiedDate"));
			}
			if(result.getString("modifiedBy") != null) {
				news.setModifiedBy(result.getString("modifiedBy"));
			}
			return news ;
		}catch(SQLException e) {
			return null ;
		}
	}
	
}
