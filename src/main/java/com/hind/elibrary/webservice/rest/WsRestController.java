package com.hind.elibrary.webservice.rest;

import java.util.Collection;
import java.util.LinkedList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hind.elibrary.model.Book;
import com.hind.elibrary.service.BookService;
import com.hind.elibrary.webservice.rest.model.BookDTO;

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

	private BookDTO convert(Book book) {
		BookDTO resultBookDTO = null;
		if (book != null) {
			resultBookDTO = new BookDTO();
			resultBookDTO.setId(book.getId());
			resultBookDTO.setAuthor(book.getAuthor());
			resultBookDTO.setTitle(book.getTitle());
		}
		return resultBookDTO;
	}

	private Collection<BookDTO> convert(Collection<Book> books) {
		Collection<BookDTO> resultBookDTOs = new LinkedList<BookDTO>();
		if (books != null && !books.isEmpty()) {
			for (Book book : books) {
				BookDTO resultBookDTO = new BookDTO();
				resultBookDTO.setId(book.getId());
				resultBookDTO.setAuthor(book.getAuthor());
				resultBookDTO.setTitle(book.getTitle());
				resultBookDTOs.add(resultBookDTO);
			}
		}
		return resultBookDTOs;
	}
}
