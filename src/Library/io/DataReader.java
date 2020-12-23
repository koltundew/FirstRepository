package Library.io;
import Library.model.Book;
import Library.model.LibraryUser;
import Library.model.Magazine;

import javax.xml.crypto.Data;
import java.util.Scanner;
public class DataReader {
    private Scanner sc = new Scanner(System.in);
    private ConsolePrinter printer;

    public DataReader(ConsolePrinter printer){
        this.printer = printer;
    }

    public void close()
    {
        sc.close();
    }
    public int getInt()
    {
        try{return sc.nextInt();}
        finally {
            sc.nextLine();
        }

    }
    public String getString(){
        return sc.nextLine();
    }
    public Book readAndCreateBook()
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
    public LibraryUser createLibraryUser(){
        printer.printLine("Imie: ");
        String firstName = sc.nextLine();
        printer.printLine("Nazwisko");
        String lastName = sc.nextLine();
        printer.printLine("Pesel: ");
        String pesel = sc.nextLine();
        return new LibraryUser(firstName,lastName,pesel);
    }

}
