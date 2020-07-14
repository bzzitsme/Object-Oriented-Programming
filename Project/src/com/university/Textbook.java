package com.university;

import java.io.Serializable;

public class Textbook implements Serializable {
    public String isbn;
    public String title;
    public String author;

    public Textbook(String isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
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

    @Override
    public String toString() {
        return title + ", book author is " + author + ", book isbn is " + isbn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Textbook textbook = (Textbook) o;
        return isbn.equals(textbook.isbn) && title.equals(textbook.title) && author.equals(textbook.author);
    }
}
