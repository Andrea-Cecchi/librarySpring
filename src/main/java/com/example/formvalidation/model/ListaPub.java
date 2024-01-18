package com.example.formvalidation.model;

import jakarta.persistence.*;

@Entity
@Table(name="listePub")
public class ListaPub {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @ManyToOne
    @JoinColumn
    private User user;
    @ManyToOne
    @JoinColumn
    private Book book;

    public ListaPub(int id, User user, Book book) {
        this.id = id;
        this.user = user;
        this.book = book;
    }

    public ListaPub(User user, Book book) {
        this.user = user;
        this.book = book;
    }

    public ListaPub() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
