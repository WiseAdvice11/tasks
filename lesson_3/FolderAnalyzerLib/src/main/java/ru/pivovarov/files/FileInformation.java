package ru.pivovarov.files;

public class FileInformation {

    String fileName;
    long fileSize;

    public FileInformation(String fileName, long fileSize) {

        this.fileName = fileName;
        this.fileSize = fileSize;
    }

    @Override
    public String toString() {
        return "{" +
                "fileName= '" + fileName + '\'' +
                ", fileSize= " + fileSize +
                " bytes }\n";
    }


}
