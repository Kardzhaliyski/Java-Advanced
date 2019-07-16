package com.company;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class AllCapitals {
    public static void main(String[] args) {
        Path userDir = Path.of(System.getProperty("user.dir"));
        Path pathIn = Path.of(userDir + "\\res\\input.txt");
        Path pathOut = Path.of(userDir + "\\res\\output.txt");

        try (BufferedReader bfr = Files.newBufferedReader(pathIn);
             BufferedWriter bfw = Files.newBufferedWriter(pathOut)) {
            String line;
            while (null != (line = bfr.readLine())) {
                bfw.append(line.toUpperCase())
                        .append(System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
