package ru.pivovarov.application;

import com.beust.jcommander.JCommander;
import ru.pivovarov.files.FolderProcessor;


public class Launcher {

    public static void main (String [] args) {

        FolderProcessor folderProcessor = new FolderProcessor();
        Render renderer = new Render();
        Converter converter = new Converter();


        JCommander.newBuilder()
                  .addObject(converter)
                  .build()
                  .parse(args);

      
        renderer.render(folderProcessor.getInformation(converter.getReferences()));
    }
}