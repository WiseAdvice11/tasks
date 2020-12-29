package ru.pivovarov.files;
    
import java.io.File;
import java.util.ArrayList;
import java.util.List;
	
public class ListOfFiles {

 

    public List<File>getAllFiles(String path) {

        List<File>  files = new ArrayList<>();

        File directory = new File(path);

        for (File file : directory.listFiles()) {
            if (file.isFile()) {
                files.add(file);
            }
        }
        return files;
    }
}