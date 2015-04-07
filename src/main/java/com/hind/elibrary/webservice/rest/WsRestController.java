package com.hind.elibrary.webservice.rest;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hind.elibrary.model.Book;
import com.hind.elibrary.service.BookService;

@RestController
@RequestMapping("/rest")
public class WsRestController {

	private BookService bookService;

	@Autowired
	public WsRestController(BookService bookService) {
		this.bookService = bookService;
	}

	@RequestMapping("/book")
	public Collection<Book> getAllBooks() {
		return bookService.getAllBooks();
	}

	@RequestMapping("/book/{id}")
	public Book getBook(@PathVariable Long id) {
		return bookService.getBook(id);
	}

}
