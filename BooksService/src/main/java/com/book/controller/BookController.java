package com.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.book.model.BookData;
import com.book.service.ServiceImp;

@RestController
@RequestMapping("/book")
public class BookController {

	@Autowired
	private ServiceImp imp;
	
	@PostMapping("/save")
	public BookData save(@RequestBody BookData data) {
		return imp.save(data);
	}
	
	@GetMapping("/get/{id}")
	public BookData get(@PathVariable int id) {
		return imp.get(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		imp.delete(id);		
		return id+" Deleted Succesfull";
	}
	
	@PutMapping("/update/{id}")
	public BookData update(@PathVariable int id, @RequestBody BookData data) {
		
		return imp.update(id, data);
	}
	
}
