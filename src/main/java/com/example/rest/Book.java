package com.example.rest;

public class Book {
    /**
     * Class that will be used to hold the data for the Rest API Example
     */

    private String isbn;
    private String title;
    private String author;

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
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

    public String toString() {
        return String.format("The book title is %s, author is %s and isbn is %s",
                this.getTitle(), this.getAuthor(), this.getIsbn());
    }

}
