package com.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.model.UserData;
import com.user.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService service;

	@PostMapping("/save")	
	public UserData save(@RequestBody UserData user) {
		return service.save(user);
	}
	
	@GetMapping("/get/{id}")
	public UserData get(@PathVariable int id) {
		return service.get(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
          service.delete(id);
		return id+" Deleted Successfully";
	}
	
	@PutMapping("update/{id}")
	public UserData update(@PathVariable int id, @RequestBody UserData data) {
		
		return service.update(id, data);
	}
	
}
