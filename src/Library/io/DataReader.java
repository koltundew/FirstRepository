package Library.io;
import Library.model.Book;
import Library.model.Magazine;

import java.util.Scanner;
public class DataReader {
    Scanner sc = new Scanner(System.in);

    public void close()
    {
        sc.close();
    }
    public int getInt()
    {
        int number = sc.nextInt();
        sc.nextLine();
        return number;
    }
    public Book readAndCreate()
    {
        System.out.println("Tytuł: ");
        String title = sc.nextLine();
        System.out.println("Autor: ");
        String author = sc.nextLine();
        System.out.println("Wydawnictwo: ");
        String publisher = sc.nextLine();
        System.out.println("ISBN: ");
        String isbn = sc.nextLine();
        System.out.println("Rok wydania: ");
        int year = sc.nextInt();
        sc.nextLine();
        System.out.println("Ilość stron: ");
        int pages = sc.nextInt();
        sc.nextLine();

        return new Book(title,author,year,pages,publisher,isbn);
    }
    public Magazine readAndCreateMagazine(){
        System.out.println("Tytuł: ");
        String title = sc.nextLine();
        System.out.println("Wydawnictwo: ");
        String publisher = sc.nextLine();
        System.out.println("Język: ");
        String language = sc.nextLine();
        System.out.println("Rok wydania: ");
        int year = sc.nextInt();
        System.out.println("Miesiąc: ");
        int month = sc.nextInt();
        System.out.println("Dzień: ");
        int day = sc.nextInt();

        return new Magazine(title,publisher,language,year,month,day);
    }

}
