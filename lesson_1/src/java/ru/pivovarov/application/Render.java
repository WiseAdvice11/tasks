package ru.pivovarov.application;

import ru.pivovarov.files.ListOfFiles;
import com.beust.jcommander.JCommander; 
import java.io.File;


public class Render {

	public static void main (String [] args) {

		Arguments arguments = new Arguments();
		ListOfFiles listOfFiles = new ListOfFiles();

		JCommander.newBuilder()
		.addObject(arguments)
		.build()
		.parse(args);
 		
   	    for (File name : listOfFiles.GetAllFiles(arguments.path))
   	    {
            System.out.println(name +" "+ name.length() + " bytes");
        }
   		
   	}
}