package Library.io.file;

import Library.model.Library;

public interface FileManager {
     Library importData();
     void exportData(Library library);
}
