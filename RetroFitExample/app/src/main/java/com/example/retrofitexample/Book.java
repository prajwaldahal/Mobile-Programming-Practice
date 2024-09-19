package com.example.retrofitexample;

public class Book {
    private String isbnno;
    private String name;
    private String author;

    public Book(String isbnno, String name, String author) {
        this.isbnno = isbnno;
        this.name = name;
        this.author = author;
    }
    public String getIsbnno() {
        return isbnno;
    }
    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

}
