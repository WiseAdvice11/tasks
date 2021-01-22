package ru.pivovarov.files;
  import java.io.File;
    import java.util.ArrayList;
    import java.util.HashMap;
    import java.util.List;
    import java.util.Map;

public class FolderProcessor {



    public Map<String, List<FileInformation>> getInformation(List<String> folderNames) {

        List<Thread> threads = new ArrayList<>();

        Map<String, List<FileInformation>> folders = new HashMap<>();

        for (String folderName : folderNames) {
          
            Runnable task = () -> {

                System.out.println("In Task " + folderName);

                List<FileInformation> fileInformations = new ArrayList<>();

                File folder = new File(folderName);
                // массив файлов для заполнения конструктора.
                File[] files = folder.listFiles();
                // массив  имен файлов для заполнения конструктора.
                String fileNames[] = folder.list();

                for (int i = 0; i < files.length; i++) {
                    fileInformations.add(new FileInformation(fileNames[i], files[i].length()));
                }
               
                folders.put(folderName, fileInformations);
                System.out.println("From task " + folderName);
            };

            Thread thread = new Thread(task);
            thread.start();
            threads.add(thread);
           
        }

        for (Thread thread1 : threads) {

            try {
                thread1.join(); 
            } 
            catch (InterruptedException e) {
                throw new IllegalArgumentException (e);
            }

        }
        return folders;
    }
}





