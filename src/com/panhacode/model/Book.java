package com.panhacode.model;

import java.time.LocalDate;

public class Book {
    private static int nextId = 1;

    private int id;
    private String title;
    private Author author;
    private LocalDate publishedYear;
    private boolean status;

    public Book(String title, Author author, LocalDate publishedYear) {
        this.id = nextId++;
        this.title = title;
        this.author = author;
        this.publishedYear = publishedYear;
        this.status = true; // Assuming the default status is true (available)
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public LocalDate getPublishedYear() {
        return publishedYear;
    }

    public void setPublishedYear(LocalDate publishedYear) {
        this.publishedYear = publishedYear;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
