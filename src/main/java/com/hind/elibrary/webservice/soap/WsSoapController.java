package com.hind.elibrary.webservice.soap;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;

import com.hind.elibrary.service.BookService;

@Endpoint
public class WsSoapController {

	private static final String NAMESPACE_URI = "http://hind.com/elibrary";

	private BookService bookService;

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "BookRequest")
	public void handleBookRequest() {
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
	}

	public BookService getBookService() {
		return bookService;
	}

	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}

}
