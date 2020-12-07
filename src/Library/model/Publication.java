package Library.model;

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
}
