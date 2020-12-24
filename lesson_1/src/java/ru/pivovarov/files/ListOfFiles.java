package ru.world.tool;
    
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ListOfFiles {

	public List<File> getListOfFiles(String path) {

    	File directory = new File(path); 
        List<File> list = new ArrayList<>();
       
        for (File file : directory.listFiles()) {
            if (file.isFile()){
                System.out.println(file + " <=  " + file.length() + " bytes => " + "\n");
            }
            list.add(file);
        }
        return list ;
     }
}