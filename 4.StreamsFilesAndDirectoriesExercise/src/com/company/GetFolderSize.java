package com.company;

import java.io.File;
import java.nio.file.Path;

public class GetFolderSize {
    public static void main(String[] args) {
        Path userDir = Path.of(System.getProperty("user.dir"));
        File root = new File(userDir + "\\res\\Exercises Resources");

        System.out.printf("Folder size: %d", getFolderSize(root));
    }

    private static Long getFolderSize(File folder) {
        long length = 0L;
        File[] files = folder.listFiles();
        if (files == null) {
            return 0L;
        }

        for (File file : files) {
            if (file.isDirectory()) {
                length += getFolderSize(file);
            } else {
                length += file.length();
            }
        }

        return length;
    }
}
