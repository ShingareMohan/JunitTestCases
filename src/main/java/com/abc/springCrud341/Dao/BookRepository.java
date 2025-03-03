package com.abc.springCrud341.Dao;

import com.abc.springCrud341.Entity.Book;
import org.hibernate.query.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
    //public Book findById(int id);




}
