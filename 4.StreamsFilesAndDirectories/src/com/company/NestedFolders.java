package com.company;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayDeque;

public class NestedFolders {
    public static void main(String[] args) throws IOException {
        Path userDir = Path.of(System.getProperty("user.dir"));

        Path pathRoot = Path.of(userDir.toString() + "/res/Files-and-Streams");
        ArrayDeque<String> todoStack = new ArrayDeque<>();
        File currFolder = new File(pathRoot.toString());
        int folderCounter = 1;
        while (true){
            System.out.println(currFolder.getName());

            if (currFolder.listFiles() != null) {
                var tempStack = new ArrayDeque<String>();
                for (File file : currFolder.listFiles()) {
                    if (file.isDirectory()) {
                        tempStack.push(file.getAbsolutePath());
                    }
                }

                while (!tempStack.isEmpty()) {
                    todoStack.push(tempStack.pop());
                }
            }

            if (!todoStack.isEmpty()) {
                currFolder = new File(todoStack.pop());
                folderCounter++;
            } else {
                break;
            }
        }

        System.out.println(folderCounter + " folders");

    }
}
