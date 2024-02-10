package com.jpa.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jpa.dao.BooksRepository;
import com.jpa.dto.Books;

@RestController
public class BooksController {
	@Autowired
	BooksRepository bookRepository;

	// save
	@PostMapping("/save")
	public String saveBook(@RequestBody Books book) {
		bookRepository.save(book);
		return "Data added successfully!!!!";
	}

	// update
	@PostMapping("/update")
	public String updateBook(@RequestBody Books book) {

		Books books = new Books();
		books.setBookId(book.getBookId());
		books.setBookName(book.getBookName());
		books.setAuthor(book.getAuthor());
		books.setPrice(book.getPrice());

		bookRepository.save(books);
		return "Data updated successfully";

	}

	// delete
	@PostMapping("/delete/{bookId}")
	public String deleteBook(@PathVariable int bookId) {
		bookRepository.deleteById(bookId);
		return "deleted successfully!!!";
	}

	// findById
	@GetMapping("search/{bookId}")
	public Optional<Books> findById(@PathVariable int bookId) {
		Optional<Books> list = bookRepository.findById(bookId);
		return list;

	}

}
