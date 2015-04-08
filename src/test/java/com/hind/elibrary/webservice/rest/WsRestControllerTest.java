package com.hind.elibrary.webservice.rest;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.hind.elibrary.model.Book;
import com.hind.elibrary.service.BookService;


public class WsRestControllerTest {

	private MockMvc mockMvc;
	private BookService bookServiceMock;
	private WsRestController wsRestController;
	
	@Before
	public void setup(){
		bookServiceMock = Mockito.mock(BookService.class);
		wsRestController = new WsRestController(bookServiceMock);
		mockMvc = MockMvcBuilders.standaloneSetup(wsRestController).build();
	}

	@Test
	public void shouldGetAllBooksMethodReturnAllBooks() throws Exception{
		//given
		Book b1 = new Book();
		b1.setId(1l);
		b1.setAuthor("author");
		b1.setTitle("title");
		Mockito.when(bookServiceMock.getAllBooks()).thenReturn(Arrays.asList(b1));
		
		//when
		ResultActions result = mockMvc.perform(MockMvcRequestBuilders.get("/rest/book"));
		
		//then
		Mockito.verify(bookServiceMock, Mockito.times(1)).getAllBooks();
		Mockito.verifyNoMoreInteractions(bookServiceMock);
		
		result.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	public void shouldGetBookMethodReturnBookWhenGivenExistingId()throws Exception{
		//given
		Book b1 = new Book();
		b1.setId(2l);
		b1.setAuthor("author");
		b1.setTitle("title");
		Mockito.when(bookServiceMock.getBook(Mockito.eq(2l))).thenReturn(b1);
		
		//when
		ResultActions result = mockMvc.perform(MockMvcRequestBuilders.get("/rest/book/2"));
		
		//then
		Mockito.verify(bookServiceMock, Mockito.times(1)).getBook(Mockito.eq(2l));
		Mockito.verifyNoMoreInteractions(bookServiceMock);
		
		result.andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	public void shouldGetMethodReturnNullWhenGivenNotExistingId() throws Exception {
		//given
		Mockito.when(bookServiceMock.getBook(Mockito.anyLong())).thenReturn(null);

		//when
		ResultActions result = mockMvc.perform(MockMvcRequestBuilders.get("/rest/book/-1"));

		//then
		Mockito.verify(bookServiceMock, Mockito.times(1)).getBook(Mockito.eq(-1l));
		Mockito.verifyNoMoreInteractions(bookServiceMock);

		result.andExpect(MockMvcResultMatchers.status().isOk());
	}
}