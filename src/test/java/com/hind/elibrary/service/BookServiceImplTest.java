package com.hind.elibrary.service;

import java.util.Collection;
import java.util.LinkedList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.hind.elibrary.dao.BookDao;
import com.hind.elibrary.model.Book;

public class BookServiceImplTest {

	private static String AUTHOR = "Author";
	private static String TITLE = "Title";

	private BookDao bookDaoMock;
	private BookServiceImpl bookService;
	private Collection<Book> books;
	private Book b1;

	@Before
	public void setUp() {
		b1 = new Book();
		b1.setAuthor(AUTHOR);
		b1.setTitle(TITLE);

		books = new LinkedList<Book>();
		books.add(b1);

		bookDaoMock = Mockito.mock(BookDao.class);
		Mockito.when(bookDaoMock.getAll()).thenReturn(books);

		bookService = new BookServiceImpl();
		bookService.setBookDao(bookDaoMock);

	}

	@Test
	public void shouldCallBookDaoToGetAllBooks() {
		//given

		//when
		Collection<Book> resultBooks = bookService.getAllBooks();

		//then
		Mockito.verify(bookDaoMock, Mockito.times(1)).getAll();
		Assert.assertEquals(1, resultBooks.size());
		Book resultBook = (Book) resultBooks.toArray()[0];
		Assert.assertEquals(AUTHOR, resultBook.getAuthor());
		Assert.assertEquals(TITLE, resultBook.getTitle());
	}
}
