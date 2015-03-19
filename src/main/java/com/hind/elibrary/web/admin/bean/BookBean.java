package com.hind.elibrary.web.admin.bean;

import java.util.Collection;
import java.util.LinkedList;

import com.hind.elibrary.model.Book;
import com.hind.elibrary.service.BookService;
import com.hind.elibrary.web.admin.model.BookDTO;

public class BookBean {

	private BookService bookService;

	public Collection<BookDTO> getBooks() {
		Collection<BookDTO> result = new LinkedList<BookDTO>();
		Collection<Book> books = bookService.getAllBooks();
		for (Book book : books) {
			BookDTO bookDTO = new BookDTO();
			bookDTO.setTitle(book.getTitle());
			bookDTO.setAuthor(book.getAuthor());
			result.add(bookDTO);
		}
		return result;
	}

	public BookService getBookService() {
		return bookService;
	}

	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}

}
