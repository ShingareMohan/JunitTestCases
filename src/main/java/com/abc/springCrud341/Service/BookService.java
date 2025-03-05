package com.abc.springCrud341.Service;

import com.abc.springCrud341.Dao.BookRepository;
import com.abc.springCrud341.Entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Component
public class BookService {
    @Autowired
    private BookRepository bookRepository;

//    private static List<Book> list1 = new ArrayList<>();
//    static {
//        list1.add(new Book(12,"java referencs","ABC"));
//        list1.add(new Book(13,"Think java","PQR"));
//        list1.add(new Book(14,"Think and Java","LMN"));
//    }

    public List<Book> getAllBooks() {
        List<Book> list = (List<Book>) this.bookRepository.findAll();
        return list;
    }

    public Optional<Book> getById(int id) {
        Optional<Book> book = null;

            book = this.bookRepository.findById(id);

        return book;
    }
     @Transactional
    public Book addBook(Book b) {
        Book result = bookRepository.save(b);
        return result;
    }

    public Book  updateBook(Book book, int id){
        book.setId(id);
        Book result1 = bookRepository.save(book);

        return result1;
    }

    public void deleteBook(int id) {
        // Check if the book exists before trying to delete it
      bookRepository.deleteById(id);
    }

    public void deleteById(int i) {
    }

    public Page<Book> getBookWithPagination(int offset, int pageSize){
        return bookRepository.findAll(PageRequest.of(offset,pageSize));
    }




//    public void update(Book book, int id){
//        book.setId(id);
//     bookRepository.save(book);

//   public List<Book> FindWithPagination(int offset, int pageSize){
//        List<Book> book1 = (List<Book>) bookRepository.findAll(PageRequest.of(offset,pageSize));
//        return book1;

}
