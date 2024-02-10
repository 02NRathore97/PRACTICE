package com.mongodb.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mongodb.dto.Books;

public interface BooksRepository extends MongoRepository<Books, Integer> {

}
