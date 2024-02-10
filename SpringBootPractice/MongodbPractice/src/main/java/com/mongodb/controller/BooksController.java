package com.mongodb.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mongodb.dto.Books;
import com.mongodb.service.BooksService;

@RestController
public class BooksController {
	@Autowired
	BooksService service;
	
	//save
	@PostMapping("/save")
	public String save(@RequestBody Books book) {
		int bookId = service.saveBooks(book);
		return "data added successfully with bookId = "+bookId;
		
	}
	
	//update
	@PostMapping("/update")
	public String update(@RequestBody Books book) {
		service.updateBook(book);
		return "data updated successfully";
		
	}
	
	//delete
	@PostMapping("/delete/{bookId}")
	public String delete(@PathVariable int bookId) {
		service.delete(bookId);
		return "data deleted successfully";
	}
	
	//search
	@GetMapping("/search/{bookId}")
	public Optional<Books> search(@PathVariable int bookId) {
		Optional<Books> list = service.findById(bookId);
		return list;
		
		
	}

}
