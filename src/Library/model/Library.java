package Library.model;


public class Library {
    private static final int MAX_BOOKS = 1000;
    private static final int MAX_MAGAZINES = 1000;
    private Book[] books = new Book[MAX_BOOKS];
    private Magazine[] magazines = new Magazine[MAX_MAGAZINES];
    private int booksNumber;
    private int magazineNumber;

    public void addBook(Book book)
    {
      if(booksNumber < MAX_BOOKS)
      {
          books[booksNumber] = book;
          booksNumber++;
      }
      else{
          System.out.println("Maksymalna liczba książek została osiągnieta");
      }

    }
    public void printBooks()
    {
        if(booksNumber == 0)
        {
            System.out.println("brak ksiązek w bibliotece");
        }
        for (int i = 0; i < booksNumber; i++) {
            books[i].printInfo();
        }
    }
    public void addMagazine(Magazine magazine)
    {
        if(magazineNumber < MAX_MAGAZINES)
        {
            magazines[magazineNumber] = magazine;
            magazineNumber++;
        }
        else{
            System.out.println("Maksymalna liczba magazynów została osiągnieta");
        }
    }
    public void printMagazines()
    {
        if(magazineNumber == 0)
        {
            System.out.println("brak ksiązek w bibliotece");
        }
        for (int i = 0; i < magazineNumber; i++) {
            magazines[i].printInfo();
        }
    }


}
