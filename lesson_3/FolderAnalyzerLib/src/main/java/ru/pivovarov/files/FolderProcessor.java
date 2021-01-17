package ru.pivovarov.files;

	import java.io.File;
    import java.util.ArrayList;
    import java.util.HashMap;
    import java.util.List;
    import java.util.Map;

public class FolderProcessor {

    public Map<String, List<FileInformation>> getInformation(List<String> folderNames) {

        Map<String, List<FileInformation>> folders = new HashMap<>();

        for (String folderName : folderNames) {

            // для каждого folderName отдельный поток
            Runnable task = () -> {

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
            };
            Thread t1 = new Thread(task);
            t1.start();
            System.out.println("*********** THREAD "+ t1.getName()+ " GET STARTED");
            try {
                t1.join();
            } 
            catch (InterruptedException e) {
                 throw new IllegalArgumentException(e);
            }
        }
        return folders;
    }
}



