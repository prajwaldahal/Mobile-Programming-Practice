package com.example.customrecyclevieweeditadd;

public class Quote {
    private int id;
    private String quote;
    private String author;
    private String image;

    public Quote(int id, String quote, String author, String image) {
        this.id = id;
        this.quote = quote;
        this.author = author;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
