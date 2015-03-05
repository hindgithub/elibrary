package com.hind.elibrary.service;

import java.util.Collection;

import com.hind.elibrary.dao.BookDao;
import com.hind.elibrary.model.Book;

public class BookServiceImpl implements BookService {

	private BookDao bookDao;

	@Override
	public Collection<Book> getAllBooks() {
		return bookDao.getAll();
	}

	public BookDao getBookDao() {
		return bookDao;
	}

	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}

}
