package Library.model;


import java.io.Serializable;
import java.util.Arrays;

public class Library implements Serializable {
    private static final int MAX_PUBLICATIONS = 2000;
    private int publicationNumber;
    private Publication[] publications = new Publication[MAX_PUBLICATIONS];

    public Publication[] getPublications(){
        Publication[] result = new Publication[publicationNumber];
        for(int i = 0; i<publicationNumber; i++){
            result[i] = publications[i];
        }
        return result;
    }


    public  void addPublication(Publication publication){
        if(publicationNumber >=MAX_PUBLICATIONS){
            throw new ArrayIndexOutOfBoundsException("Max publications exceeded"+ MAX_PUBLICATIONS);
        }
        publications[publicationNumber] = publication;
        publicationNumber++;
    }



//    @Override
//    public String toString() {
//        StringBuilder builder = new StringBuilder();
//        for(int i =0; i<publicationNumber; i++){
//            builder.append(publications[i]);
//            builder.append("\n");
//        }
//        return builder.toString();
//    }
}
