package com.abc.springCrud341.Controller;

import com.abc.springCrud341.Entity.Book;
import com.abc.springCrud341.Exception1.ResourceNoFoundException;
import com.abc.springCrud341.Service.BookService;
import com.abc.springCrud341.Entity.ErrorResponse;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
public class BookController {
//    @Autowired
//    BookRepository bookRepository;
    @Autowired
   private BookService bookService;
    @GetMapping("/books")
    public ResponseEntity<List<Book>> getBooks(){
     List<Book> list =bookService.getAllBooks();
     if(list.size()<=0){
         return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
     }
    return ResponseEntity.of(Optional.of(list));
    }
    @GetMapping("/books/{id}")
    public ResponseEntity<?> getBookById(@PathVariable ("id") int id ){

            Book book = bookService.getById(id).orElseThrow(() -> new ResourceNoFoundException("No book found with id"));
            return ResponseEntity.ok(book);

    }

    @PostMapping("/books")
    public Book addBook(@RequestBody Book book){
        Book b = this.bookService.addBook(book);
        return b;
    }
    @PutMapping("/books/{id}")
    public Book update(@RequestBody Book book, @PathVariable("id") int id ){
      this.bookService.updateBook(book, id);
      return book;
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<Book> deleteById(@PathVariable ("id") int id ){
        this.bookService.deleteBook(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
//    @Transactional
//    @PutMapping("/books/{id}")

//    public ResponseEntity <Book> UpdateBook(@RequestBody , @PathVariable("id") int id ){
//        try {
//            this.bookService.update(book, id);
//            return ResponseEntity.ok().build();
//        }
//        catch (Exception e){
//            e.printStackTrace();
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//        }
    @GetMapping("/pagination/{offset}/{pageSize}")
    public Page<Book> SortProduct(@PathVariable int offset,@PathVariable int pageSize){
        return bookService.getBookWithPagination(offset, pageSize);
    }


}
