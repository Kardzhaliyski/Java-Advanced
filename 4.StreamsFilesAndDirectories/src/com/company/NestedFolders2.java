package com.company;

import java.io.File;
import java.nio.file.Path;
import java.util.ArrayDeque;
import java.util.Deque;

public class NestedFolders2 {
    public static void main(String[] args) {
        Path userDir = Path.of(System.getProperty("user.dir"));
        Path pathRoot = Path.of(userDir.toString() + "\\res\\Files-and-Streams");
        Deque<String> todoQueue = new ArrayDeque<String>();
        todoQueue.offer(pathRoot.toString());
        int folderCounter = 0;

        while (!todoQueue.isEmpty()) {
            File currentFolder = new File(todoQueue.poll());
            folderCounter++;
            System.out.println(currentFolder.getName());
            if (currentFolder.listFiles() != null) {
                for (File file : currentFolder.listFiles()) {
                    if (file.isDirectory()) {
                        todoQueue.offer(file.getAbsolutePath());
                    }
                }
            }
        }

        System.out.println(folderCounter + " folders");

    }
}
