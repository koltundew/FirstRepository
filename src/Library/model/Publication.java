package Library.model;

import java.util.Objects;

public class Publication {
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
        return
                "year='" + year + '\'' +
                ", publisher='" + publisher + '\'' +
                ", title='" + title + '\''+" ";

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
}
