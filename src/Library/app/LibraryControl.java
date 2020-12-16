package Library.app;
import Library.model.Magazine;
import Library.model.Book;
import Library.model.Library;
import Library.model.Publication;
import Library.io.ConsolePrinter;
import Library.io.DataReader;
import Library.io.file.FileManager;
import Library.io.file.FileManagerBuilder;
import Library.exception.NoSuchOptionException;
import Library.exception.DataImportException;
import Library.exception.DataExportException;
import Library.exception.InvalidDataException;



import java.util.InputMismatchException;

public class LibraryControl {



    private ConsolePrinter printer = new ConsolePrinter();
    private DataReader dataReader = new DataReader(printer);
    private FileManager fileManager;



    private Library library;

    LibraryControl(){
        fileManager =  new FileManagerBuilder(printer,dataReader).build();
        try{
            library = fileManager.importData();
            printer.printLine("Zaimportowano dane z pliku");
        }catch (DataImportException e){
            printer.printLine(e.getMessage());
            printer.printLine("Zainiocjowano nowa baze");
            library = new Library();
        }
    }


    void controlLoop() {
        Option option;

        do {
            printOptions();
            option = getOption();
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

    private Option getOption() {
        boolean optionOk = false;
        Option option = null;
        while (!optionOk) {
            try {
                option = Option.createFromInt(dataReader.getInt());
                optionOk = true;
            } catch (NoSuchOptionException e) {
                printer.printLine(e.getMessage() + ",podaj ponownie");
            } catch (InputMismatchException ignored) {
                printer.printLine("Wprowadzono wartość, która nie jest liczbą, podaj ponownie");
            }
        }
        return option;
    }


    private void printOptions() {
        System.out.println("Wybierz opcje: ");
        for (Option option : Option.values()) {
            printer.printLine(option.toString());
        }


    }


    private void addBook() {
        try {
            Book book = dataReader.readAndCreateBook();
            library.addPublication(book);
        } catch (InputMismatchException e) {
            printer.printLine("Nie udało się utworzyć książki, niepoprawne dane");
        } catch (ArrayIndexOutOfBoundsException e) {
            printer.printLine("Osiągnieto limit pojemności, nie można dodać kolejnej książki");
        }
    }

    private void addMagazine() {
        try {
            Magazine magazine = dataReader.readAndCreateMagazine();
            library.addPublication(magazine);
        } catch (InputMismatchException e) {
            printer.printLine("Nie udało się utworzyć magazynu, niepoprawne dane");
        } catch (ArrayIndexOutOfBoundsException e) {
            printer.printLine("Osiągnieto limit pojemności, nie można dodać kolejnego magazynu");
        }
    }

    private void printBooks() {
        Publication[] publications = library.getPublications();
        printer.printBooks(publications);
    }

    private void printMagazines() {
        Publication[] publications = library.getPublications();
        printer.printMagazines(publications);
    }

    private void exit() {
        try{
            fileManager.exportData(library);
            printer.printLine("Eksport danych do pliku zakonczony powodzeniem");
        }catch (DataExportException e){
            printer.printLine(e.getMessage());
        }
        dataReader.close();
        printer.printLine("Koniec programu , papa");

    }

    private enum Option {
        EXIT(0, "Wyjście z prorgamu"),
        ADD_BOOK(1, "Dodanie książki"),
        ADD_MAGAZINE(2, "Dodanie magazynu"),
        PRINT_BOOKS(3, "Wyswietl dostępne książki"),
        PRINT_MAGAZINES(4, "Wyswietl dostępne magazyny");

        private int value;
        private String description;

        Option(int value, String description) {
            this.value = value;
            this.description = description;
        }

        @Override
        public String toString() {
            return value + " - " + description;
        }


        static  Option createFromInt(int option) throws NoSuchOptionException {
            try {
                return Option.values()[option];
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new NoSuchOptionException("Brak opcji o id" + option);
            }
        }

    }
}




