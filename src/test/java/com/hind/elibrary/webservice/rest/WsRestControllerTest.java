package com.hind.elibrary.webservice.rest;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.hind.elibrary.model.Book;
import com.hind.elibrary.service.BookService;

public class WsRestControllerTest {

	private static final String AUTHOR = "Author";
	private static final String TITLE = "Title";

	private WsRestController wsRestController;
	private BookService bookServiceMock;
	private List<Book> books;
	private Book book;

	@Before
	public void setup() {
		book = new Book();
		book.setAuthor(AUTHOR);
		book.setTitle(TITLE);

		books = new LinkedList<Book>();
		books.add(book);

		bookServiceMock = Mockito.mock(BookService.class);
		Mockito.when(bookServiceMock.getAllBooks()).thenReturn(books);

		wsRestController = new WsRestController();
		wsRestController.setBookService(bookServiceMock);
	}

	@Test
	public void shouldReturnBooks() {
		//given

		//when
		Collection<Book> booksResult = wsRestController.getAllBooks();

		//then
		Mockito.verify(bookServiceMock, Mockito.times(1)).getAllBooks();
		Assert.assertEquals(1, booksResult.size());
		Book bookResult = (Book) booksResult.toArray()[0];
		Assert.assertEquals(AUTHOR, bookResult.getAuthor());
		Assert.assertEquals(TITLE, bookResult.getTitle());
	}
}