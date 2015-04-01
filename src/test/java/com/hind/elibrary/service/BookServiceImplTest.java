package com.hind.elibrary.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.hind.elibrary.dao.BookDao;
import com.hind.elibrary.model.Book;

public class BookServiceImplTest {

	private BookDao bookDaoMock;
	private BookServiceImpl bookService;

	@Before
	public void setup() {
		bookDaoMock = Mockito.mock(BookDao.class);
		bookService = new BookServiceImpl(bookDaoMock);
	}

	@Test
	public void shouldGetAllBooksReturnEmptyCollectionWhenDaoReturnNull() {
		//given
		Mockito.when(bookDaoMock.getAll()).thenReturn(null);

		//when
		Collection<Book> resultCollection = bookService.getAllBooks();

		//then
		Mockito.verify(bookDaoMock, Mockito.times(1)).getAll();
		Assert.assertThat(resultCollection, Matchers.allOf(Matchers.notNullValue(), Matchers.hasSize(0)));
	}

	@Test
	public void shouldGetAllBooksReturnEmptyCollectionWhenDaoReturnEmptyCollecyion() {
		//given
		Mockito.when(bookDaoMock.getAll()).thenReturn(new LinkedList<Book>());

		//when
		Collection<Book> resultCollection = bookService.getAllBooks();

		//then
		Mockito.verify(bookDaoMock, Mockito.times(1)).getAll();
		Assert.assertThat(resultCollection, Matchers.allOf(Matchers.notNullValue(), Matchers.hasSize(0)));
	}

	@Test
	public void shouldCallBookDaoToGetAllBooks() {
		//given
		Book b1 = new Book();
		b1.setAuthor("author");
		b1.setTitle("title");
		Mockito.when(bookDaoMock.getAll()).thenReturn(Arrays.asList(b1));

		//when
		Collection<Book> resultBooks = bookService.getAllBooks();

		//then
		Mockito.verify(bookDaoMock, Mockito.times(1)).getAll();
		Assert.assertThat(resultBooks, Matchers.allOf(Matchers.notNullValue(), Matchers.hasSize(1)));
		Assert.assertThat(
				resultBooks,
				Matchers.contains(Matchers.allOf(Matchers.hasProperty("author", Matchers.equalTo("author")),
						Matchers.hasProperty("title", Matchers.equalTo("title")))));
	}

}
