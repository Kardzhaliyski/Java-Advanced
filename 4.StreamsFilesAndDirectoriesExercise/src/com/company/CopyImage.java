package com.company;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class CopyImage {
    public static void main(String[] args) {
        Path userdir = Path.of(System.getProperty("user.dir"));
        Path pathIn = Path.of(userdir + "\\res\\Sky.jpg");
        Path pathOut = Path.of(userdir + "\\res\\Sky-Copy.jpg");
        File fileIn = pathIn.toFile();

        try (FileInputStream fis = new FileInputStream(fileIn);
             FileOutputStream fos = new FileOutputStream(pathOut.toFile())){
            var line = fis.readAllBytes();
            fos.write(line);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
