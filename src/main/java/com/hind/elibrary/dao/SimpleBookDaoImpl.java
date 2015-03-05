package com.hind.elibrary.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import com.hind.elibrary.model.Book;

public class SimpleBookDaoImpl implements BookDao {

	private List<Book> books = new ArrayList<Book>();

	public SimpleBookDaoImpl() {
		Book book = new Book();
		book.setAuthor("Henryk Sienkiewicz");
		book.setTitle("Ogniem i mieczem");
		books.add(book);

		book = new Book();
		book.setAuthor("Władysław reymont");
		book.setTitle("Ziemia obiecana");
		books.add(book);
	}

	@Override
	public Collection<Book> getAll() {
		return new LinkedList<Book>(books);
	}

}
