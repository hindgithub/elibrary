package com.hind.elibrary.service;

import java.util.Collection;

import com.hind.elibrary.model.Book;

public interface BookService {

	Collection<Book> getAllBooks();

	Book getBook(Long id);

}
