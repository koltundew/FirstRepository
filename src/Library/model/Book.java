package Library.model;

import java.time.Year;
import java.util.Objects;

public class Book extends Publication {

    String author;

    private int pages;


    String isbn;

    public Book(String title, String author,
         int pages ,int year, String publisher, String isbn) {
       super(title, publisher, year);
        this.pages = pages;
        this.author = author;
        this.isbn = isbn;

    }



    public String getAuthor() {
        return author;
    }



    public int getPages() {
        return pages;
    }



    public String getIsbn() {
        return isbn;
    }



    public void setAuthor(String author) {
        this.author = author;
    }



    public void setPages(int pages) {
        this.pages = pages;
    }



    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Book book = (Book) o;
        return pages == book.pages &&
                Objects.equals(author, book.author) &&
                Objects.equals(isbn, book.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), author, pages, isbn);
    }

    @Override
    public String toString() {
        return super.toString()+
                "author='" + author + '\'' +
                ", pages=" + pages +
                ", isbn='" + isbn + '\'';

    }
}
