package com.abc.springCrud341.Service;

import com.abc.springCrud341.Dao.BookRepository;
import com.abc.springCrud341.Entity.Book;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.client.ExpectedCount;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.ExpectedCount.times;
import static org.mockito.Mockito.*;  // For Mockito methods like when(), verify(), etc.

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;

@SpringBootTest(classes = {UserServiceTest.class})
public class UserServiceTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService bookService;

    public List<Book> bookData;



     @Test
     @Order(1)
    public void getAllRecords_Successs(){
         List<Book> bookData = new ArrayList<Book>();
         bookData.add(new Book(1,2,"Abcd","Pqrs"));
         bookData.add(new Book(2,3,"Efgh","lmno"));
         when(bookRepository.findAll()).thenReturn(bookData);
         assertEquals(2,bookService.getAllBooks().size());
     }
//     @Test
//     @Order(2)
//     public void getBookById(){
//         List<Book> bookData = new ArrayList<Book>();
//         bookData.add(new Book(1,2,"Abcd","Pqrs"));
//         bookData.add(new Book(2,3,"Efgh","lmno"));
//         int bookId = 1;
//         when(bookRepository.findById(bookId)).thenReturn(bookData);
//         assertEquals(bookId,bookService.getById(bookId).get());
//
//     }
     @Test
     @Order(3)
     public void saveBook(){
         Book book1 = new Book(4,5,"dsjjn","jndeijd");
         when(bookRepository.save(book1)).thenReturn(book1);
         assertEquals(book1,bookService.addBook(book1));
     }
@Test
@Order(4)
     public void UpdateTest(){
         Book book1 = new Book(4,5,"dsjjn","jndeijd");
         when(bookRepository.save(book1)).thenReturn(book1);

    int id =4;
    assertEquals(book1,bookService.updateBook(book1, id ));
     }
     @Test
     @Order(5)
     public void deleteTest(){
         Book book1 = new Book(4,5,"dsjjn","jndeijd");
        doNothing().when(bookRepository).deleteById(4);
        bookService.deleteBook(4);
        verify(bookRepository,times(1)).deleteById(1);
     }

    private BookService verify(BookRepository bookRepository, ExpectedCount times) {
         return bookService;
    }


}
