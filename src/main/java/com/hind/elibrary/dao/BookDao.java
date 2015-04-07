package com.hind.elibrary.dao;

import java.util.Collection;

import com.hind.elibrary.model.Book;

public interface BookDao {

	Collection<Book> getAll();

	Book get(Long id);

}
