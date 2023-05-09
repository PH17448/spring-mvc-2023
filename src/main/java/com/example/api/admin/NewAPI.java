package com.example.api.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.NewsDTO;
import com.example.service.INewService;

@RestController(value="newAPIOfAdmin")
public class NewAPI {
	
	@Autowired
	private INewService newService ;
	
	@PostMapping("/api/new")
	public NewsDTO createNew(@RequestBody NewsDTO newDTO) {
		
		return newService.save(newDTO); 
	}
	@PutMapping("/api/new")
	public NewsDTO updateNew(@RequestBody NewsDTO updateNew) {
		
		return newService.save(updateNew) ;
	}
	@DeleteMapping("/api/new")
	public void deleteNew(@RequestBody long[] ids) {
		newService.delete(ids);
	}
}
