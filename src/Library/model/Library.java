package Library.model;


import java.io.Serializable;
import java.util.Arrays;

public class Library implements Serializable {
    private static final int INITIAL_CAPACITY = 1;
    private int publicationNumber;
    private Publication[] publications = new Publication[INITIAL_CAPACITY];

    public Publication[] getPublications() {
        Publication[] result = new Publication[publicationNumber];
        for (int i = 0; i < publicationNumber; i++) {
            result[i] = publications[i];
        }
        return result;
    }


    public void addPublication(Publication publication) {
        if (publicationNumber == publications.length) {
            publications = Arrays.copyOf(publications, publications.length * 2);
        }
        publications[publicationNumber] = publication;
        publicationNumber++;
    }

    public boolean removePublication(Publication pub) {
        final int NOT_FOUND = -1;
        int found = NOT_FOUND;
        int i = 0;
        while (i < publications.length && found == NOT_FOUND) {
            if (pub.equals(publications[i])) {
                found = i;
            } else {
                i++;
            }
        }

        if (found != NOT_FOUND) {
            System.arraycopy(publications, found + 1, publications, found, publications.length - found - 1);
            publicationNumber++;
        }
        return found != NOT_FOUND;
    }
}



//
//    @Override
//    public String toString() {
//        StringBuilder builder = new StringBuilder();
//        for(int i =0; i<publicationNumber; i++){
//            builder.append(publications[i]);
//            builder.append("\n");
//        }
//        return builder.toString();
//    }

