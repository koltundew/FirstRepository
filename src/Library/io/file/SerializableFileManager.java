package Library.io.file;
import Library.exception.DataExportException;
import Library.exception.DataImportException;
import Library.exception.DataExportException;
import Library.model.Library;
import java.io.*;

public class SerializableFileManager implements FileManager{

    private static final String FILE_NAME = "Library.io";

    @Override
    public void exportData(Library library){
        try(FileOutputStream fos = new FileOutputStream(FILE_NAME);
            ObjectOutputStream oos  = new ObjectOutputStream(fos);
        ){
            oos.writeObject(library);
        }catch (FileNotFoundException e){
            throw new DataExportException("Brak pliku "+ FILE_NAME);
        }catch (IOException e){
            throw new DataExportException("Blad zapisu danych do pliku "+ FILE_NAME);
        }
    }
    @Override
    public Library importData(){
        try(FileInputStream fis = new FileInputStream(FILE_NAME);
            ObjectInputStream ois  = new ObjectInputStream(fis);
        ){
           return (Library) ois.readObject();
        }catch (FileNotFoundException e){
            throw new DataImportException("Brak pliku "+ FILE_NAME);
        }catch (IOException e){
            throw new DataImportException("Blad odczytu pliku "+ FILE_NAME);
        }catch(ClassNotFoundException e){
            throw new DataImportException("Niezgodny typ danych pliku " + FILE_NAME);
        }
    }




}
