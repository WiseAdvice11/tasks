package ru.pivovarov.files;
    
import java.io.File;
import java.util.ArrayList;
import java.util.List;
	
public class ListOfFiles {

 List<File>  files = new ArrayList<>();

    public List<File> GetAllFiles(String path) {

        File directory = new File(path);

        for (File file : directory.listFiles()) {
            if (file.isFile()) {
                files.add(file);
            }
        }
        return files;
    }
}