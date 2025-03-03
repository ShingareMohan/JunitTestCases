package com.abc.springCrud341.Entity;

import jakarta.persistence.*;

@Entity
@Table(name="books")
public class Book {

    @Id
   // @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="book_id")

    private int id;
    @Version
    private Integer version;
    private String title;
    private String author;

    public Book(int id, Integer version, String title, String author) {
        this.id = id;
        this.version = version;
        this.title = title;
        this.author = author;
    }

    public Book() {
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = Integer.parseInt(String.valueOf(id));
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }


   // public Book orElseThrow(Object noBookFoundWithId) {
    }

