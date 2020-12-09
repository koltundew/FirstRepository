package Library.app;
import Library.model.Book;
import Library.model.Library;
import Library.io.DataReader;
import Library.model.Magazine;

public class LibraryControl {


    private DataReader dataReader = new DataReader();
    //"biblioteka przechowujaca dane
    private Library library = new Library();


    public void controlLoop() {
        Option option;

        do {
            printOptions();
            option = Option.createFromInt(dataReader.getInt());
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
        } while (option != Option.EXIT);
    }
        private void printOptions()
    {
        System.out.println("Wybierz opcje: ");
        for(Option option : Option.values()){
            System.out.println(option);
        }


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



