package Library.model;

public class Magazine extends Publication {
    private int month;
    private int day;
    private String language;

    public Magazine(String title, String publisher, String language, int year, int month, int day){
super(title, publisher, year);
this.language = language;
this.month = month;
this.day = day;

  }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public String getLanguage() {
        return language;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
    @Override
    public void printInfo()
    {
        String info = "Tytul: "+getTitle()+ " wydawnictwo: "+ getPublisher() +" Rok: "+ getYear()+" Miesiąc: "+getMonth()+" Dzień: "+getDay()
                +" Język: "+getLanguage();
        System.out.println(info);
    }
}
