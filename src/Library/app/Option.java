package Library.app;

import Library.exception.NoSuchOptionException;

enum Option {
    EXIT(0,"Wyjście z prorgamu"),
    ADD_BOOK(1,"Dodanie książki"),
    ADD_MAGAZINE(2,"Dodanie magazynu"),
    PRINT_BOOKS(3,"Wyswietl dostępne książki"),
    PRINT_MAGAZINES(4,"Wyswietl dostępne magazyny");

    private int value;
    private String description;

     public int getValue() {
         return value;
     }

     public String getDescription() {
         return description;
     }
     Option(int value, String description){
         this.value = value;
         this.description  = description;
     }

     @Override
     public String toString() {
         return value + " - "+ description;
     }
     static Option createFromInt(int option) throws NoSuchOptionException{
         try {
             return Option.values()[option];
         } catch (ArrayIndexOutOfBoundsException e) {
             throw new NoSuchOptionException("Brak opcji o id" + option);
         }
     }
 }
