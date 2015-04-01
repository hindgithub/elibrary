package com.hind.elibrary.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hind.elibrary.dao.BookDao;
import com.hind.elibrary.model.Book;

@Service
public class BookServiceImpl implements BookService {

	private BookDao bookDao;

	@Autowired
	public BookServiceImpl(BookDao bookDao) {
		this.bookDao = bookDao;
	}

	@Override
	public Collection<Book> getAllBooks() {
		return bookDao.getAll();
	}

}
