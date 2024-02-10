package com.jpa.dao;

import org.springframework.data.repository.CrudRepository;

import com.jpa.dto.Books;

public interface BooksRepository extends CrudRepository<Books, Integer> {

}
