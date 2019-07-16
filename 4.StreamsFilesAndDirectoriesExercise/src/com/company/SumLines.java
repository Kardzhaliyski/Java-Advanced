package com.company;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class SumLines {
    public static void main(String[] args) {
        Path userDir = Path.of(System.getProperty("user.dir"));
        Path pathIn = Path.of(userDir.toString() + "\\res\\input.txt");

        try(BufferedReader bfr = Files.newBufferedReader(pathIn)) {
            String line;

            while ((line = bfr.readLine()) != null) {
                int lineSum = 0;
                for (int i = 0; i < line.length(); i++) {
                    lineSum += line.charAt(i);
                }

                System.out.println(lineSum);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
