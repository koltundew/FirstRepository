package Library.io;
import Library.model.LibraryUser;
import Library.model.Publication;
import Library.model.Magazine;
import Library.model.Book;
import java.util.Collection;


public class ConsolePrinter {
    public void printBooks(Collection<Publication>publications){
        int counter = 0;
        for(Publication publication : publications){
            if(publication instanceof Book){
                printLine(publication.toString());
                counter++;
            }
        }
        if(counter == 0){
            System.out.println("Brak książek w bibliotece");
        }
    }
    public void printMagazines(Collection<Publication>publications){
        int counter = 0;
        for(Publication publication : publications){
            if(publication instanceof Magazine){
                printLine(publication.toString());
                counter++;
            }
        }
        if(counter == 0){
            System.out.println("Brak książek w bibliotece");
        }
    }

    public void printUsers(Collection<LibraryUser>users){
        for(LibraryUser user : users){
            printLine(user.toString());
        }
    }


    public void printLine(String text){
        System.out.println(text);
    }
}
