package com.example.api.web;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.NewsDTO;

@RestController(value="newAPIOfAdmin")
public class NewAPI {
	
	
	
	@PostMapping("/api/new")
	public NewsDTO createNew(@RequestBody NewsDTO newDTO) {
		
		return newDTO ;
	}
	@PutMapping("/api/new")
	public NewsDTO updateNew(@RequestBody NewsDTO newDTO) {
		
		return newDTO ;
	}
	@DeleteMapping("/api/new")
	public void deleteNew(@RequestBody long[] ids) {
		
	}
	
}
