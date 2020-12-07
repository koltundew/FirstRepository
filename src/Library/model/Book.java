package Library.model;

import java.time.Year;

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

    public void printInfo()
    {
        String info = "tytuł: "+getTitle() + "; " +"autor: "+ author + "; " + "Data wyadania: "+getYear() + "; "
                + "ilość stron: "+pages + "; " + "wydawnictwo: "+getPublisher() + "; ";
        if(isbn != null)
        {
            info = info + ";" + "isbn: "+isbn;
        }
        System.out.println(info);
    }
}
