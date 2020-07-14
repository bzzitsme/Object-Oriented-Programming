package Main;

import java.io.Serializable;
import java.util.Objects;

public class Textbook implements Serializable {
    public String title;
    public String authors;
    public String isbn;

    public Textbook(String title, String authors, String isbn) {
        this.title = title;
        this.authors = authors;
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return "Textbook's name is " + title + " , author is " + authors + " , isbn is " + isbn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Textbook textbook = (Textbook) o;
        return Objects.equals(isbn, textbook.isbn) &&
                Objects.equals(title, textbook.title) &&
                Objects.equals(authors, textbook.authors);
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

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }
}