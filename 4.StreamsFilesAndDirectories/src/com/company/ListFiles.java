package com.company;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ListFiles {
    public static void main(String[] args) {

        String userDir = System.getProperty("user.dir");
        Path path = Paths.get(userDir + "/res/Files-and-Streams");
        File file = new File(path.toString());
        File[] files = file.listFiles();
        for (File f1 : files) {
            if(!f1.isDirectory()) {
                System.out.printf("%s: [%d]%n", f1.getName(), f1.length());
            }
        }
        System.out.println();


    }
}
