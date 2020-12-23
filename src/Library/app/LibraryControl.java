package Library.app;

import Library.exception.*;
import Library.model.*;
import Library.model.comparator.AlphabeticalTitleComparator;
import Library.io.ConsolePrinter;
import Library.io.DataReader;
import Library.io.file.FileManager;
import Library.io.file.FileManagerBuilder;


import java.util.Arrays;
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
                case DELETE_BOOK:
                    deleteBook();
                    break;
                case DELETE_MAGAZINE:
                    deleteMagazine();
                    break;
                case ADD_USER:
                    addUser();
                    break;
                case PRINT_USER:
                    printUsers();
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
    private void addUser(){
        LibraryUser libraryUser = dataReader.createLibraryUser();
        try{
            library.addUser(libraryUser);
        }catch (UserAlreadyExistException e){
            printer.printLine(e.getMessage());
        }
    }

    private void printBooks() {
        printer.printBooks(library.getPublications().values());
    }

    private void printMagazines() {
        printer.printMagazines(library.getPublications().values());
    }

    private void printUsers(){
        printer.printUsers(library.getUsers().values());
    }

//    private Publication[] getSortedPublications(){
//        Publication[] publications = library.getPublications();
//        Arrays.sort(publications, new AlphabeticalTitleComparator());
//        return publications;
//    }

    private void deleteMagazine(){
        try{
            Magazine magazine = dataReader.readAndCreateMagazine();
            if(library.removePublication(magazine))
                printer.printLine("Usunięto magazyn");
            else printer.printLine("Brak wskazanego magazynu");
        }catch (InputMismatchException e ){
            printer.printLine("Nie udalo sie utwrzoyc magazynu, niepoprawne dane");
        }
    }
    private void deleteBook(){
        try{
            Book book = dataReader.readAndCreateBook();
            if(library.removePublication(book))
                printer.printLine("Usunięto książke");
            else printer.printLine("Brak wskazanego książki");
        }catch (InputMismatchException e ){
            printer.printLine("Nie udalo sie utwrzoyc książki, niepoprawne dane");
        }
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
        PRINT_MAGAZINES(4, "Wyswietl dostępne magazyny"),
        DELETE_BOOK(5, "Usun książke"),
        DELETE_MAGAZINE(6, "Usun magazyn"),
        ADD_USER(7, "Dodaj czytelnika"),
        PRINT_USER(8, "Wyświetl czytelników");



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


        static Option createFromInt(int option) throws NoSuchOptionException {
            try {
                return Option.values()[option];
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new NoSuchOptionException("Brak opcji o id" + option);
            }
        }


    }
}




