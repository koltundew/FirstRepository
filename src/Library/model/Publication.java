package Library.model;

import java.io.Serializable;
import java.util.Objects;

public abstract class Publication implements Serializable, Comparable <Publication> {

    public abstract String toCsv();

    private int year;
    private String publisher;
    private String title;

    Publication(String title,String publisher, int year)
    {
        this.title = title;
        this.publisher = publisher;
        this.year = year;
    }


    public int getYear() {
        return year;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getTitle() {
        return title;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return  "title= ,"+title +" "+
                "year='" + year + '\'' +
                ", publisher='" + publisher + '\'' ;


    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Publication that = (Publication) o;
        return year == that.year &&
                Objects.equals(publisher, that.publisher) &&
                Objects.equals(title, that.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, publisher, title);
    }

    @Override
    public int compareTo(Publication p){
        return title.compareToIgnoreCase(p.title);
    }

}
