package com.mongodb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mongodb.dao.BooksRepository;
import com.mongodb.dto.Books;

@Service
public class BooksService {
	@Autowired
	BooksRepository booksRepository;
	
	//save
	public int saveBooks(Books book) {
		booksRepository.save(book);
		return book.getBookId();
		
	}
	
	
	//update
	public void updateBook(Books book) {
		
		Books books = new Books();
		books.setBookId(book.getBookId());
		books.setBookname(book.getBookName());
		books.setAuthor(book.getAuthor());
		books.setPrice(book.getPrice());
		
		booksRepository.save(books);
	}
	
	//delete
	public void delete(int bookId) {
		booksRepository.deleteById(bookId);
		
	}
	
	//search
	public Optional<Books> findById(int bookId){
		Optional<Books> list = booksRepository.findById(bookId);
		return list;
		
	}
}
