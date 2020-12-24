package ru.world.scanner;

import ru.world.tool.Checker;
import com.beust.jcommander.JCommander; 

public class Render {

	public static void main (String [] args) {
		Arguments arguments = new Arguments();

		JCommander.newBuilder()
		.addObject(arguments)
		.build()
		.parse(args);

 		ListOfFiles listoffiles = new ListOfFiles();
   		listoffiles.getListOfFiles(arguments.path);
   		listoffiles.showList
	}
}