package Library.io;
import Library.model.Publication;
import Library.model.Magazine;
import Library.model.Book;
public class ConsolePrinter {
    public void printBooks(Publication[] publications){
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
    public void printMagazines(Publication[] publications){
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

    public void printLine(String text){
        System.out.println(text);
    }
}
