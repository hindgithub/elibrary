package com.hind.elibrary.webservice.soap;

import java.util.Collection;
import java.util.LinkedList;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.hind.elibrary.model.Book;
import com.hind.elibrary.service.BookService;
import com.hind.elibrary.webservice.soap.model.BookResponse;
import com.hind.elibrary.webservice.soap.model.BookType;

@Endpoint
public class WsSoapController {

	private static final String NAMESPACE_URI = "http://hind.com/elibrary/webservice/soap/model";

	private BookService bookService;

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "BookRequest")
	@ResponsePayload
	public BookResponse handleBookRequest() {
		Collection<Book> books = bookService.getAllBooks();
		Collection<BookType> resultBooks = new LinkedList<BookType>();
		for (Book book : books) {
			BookType bookType = new BookType();
			bookType.setAuthor(book.getAuthor());
			bookType.setTitle(book.getTitle());
			resultBooks.add(bookType);
		}
		BookResponse response = new BookResponse();
		response.getBook().addAll(resultBooks);
		return response;
	}

	public BookService getBookService() {
		return bookService;
	}

	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}

}
