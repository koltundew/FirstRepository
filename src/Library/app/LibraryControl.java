package Library.app;
import Library.model.Book;
import Library.model.Library;
import Library.io.DataReader;
import Library.model.Magazine;

public class LibraryControl {

    //zmienne do kontrolowania programu
    private static final int EXIT = 0;
    private static final int ADD_BOOK = 1;
    private static final int ADD_MAGAZINE = 2;
    private static final int PRINT_BOOKS = 3;
    private static final int PRINT_MAGAZINES = 4;
    //zmienna do komunikacji z uzytkownikiem
    private DataReader dataReader = new DataReader();
    //"biblioteka przechowujaca dane
    private Library library = new Library();


    public void controlLoop() {

        int option;
        do {
            printOptions();
            option = dataReader.getInt();
            switch (option) {
                case ADD_BOOK:
                    addBook();
                    break;
                case ADD_MAGAZINE:
                    addMagazine();
                    break;
                case PRINT_BOOKS:
                    printBooks();
                    break;
                case PRINT_MAGAZINES:
                    printMagazines();
                    break;
                case EXIT:
                    exit();
                    break;
                default:
                    System.out.println("nie ma takiej opcji, wprowadź ponownie");
            }
        } while (option != EXIT);
    }
        private void printOptions()
    {
        System.out.println("Wybierz opcje");
        System.out.println(EXIT+ " wyjscie z programu");
        System.out.println(ADD_BOOK+" Dodanie nowej książki");
        System.out.println(ADD_MAGAZINE+" Dodanie nowego magazynu");
        System.out.println(PRINT_BOOKS+" wyswietl dostepne ksiazki");
        System.out.println(PRINT_MAGAZINES+" wyswietl dostepne magazyny");


    }

    private void addBook()
    {
        Book book = dataReader.readAndCreate();
        library.addBook(book);
    }
    private void addMagazine()
    {
        Magazine magazine = dataReader.readAndCreateMagazine();
        library.addMagazine(magazine);
    }

    private void printBooks()
    {
        library.printBooks();
    }
    private void printMagazines()
    {
        library.printMagazines();
    }
    private void exit()
    {
        System.out.println("koniec programu , papa");
        dataReader.close();
    }

}



