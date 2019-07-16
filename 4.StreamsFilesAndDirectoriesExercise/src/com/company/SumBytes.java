package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class SumBytes {
    public static void main(String[] args) {
        Path userDir = Path.of(System.getProperty("user.dir"));
        Path pathIn = Path.of(userDir.toString() + "\\res\\input.txt");
        Long asciiCounter = 0L;

        try (BufferedReader bfr = Files.newBufferedReader(pathIn)) {
            String line;

            while ((line = bfr.readLine()) != null) {
                for (int i = 0; i < line.length(); i++) {
                    asciiCounter += line.charAt(i);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } ;

        System.out.println(asciiCounter);
    }
}
