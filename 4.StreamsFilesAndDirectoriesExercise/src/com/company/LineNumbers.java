package com.company;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class LineNumbers {
    public static void main(String[] args) {
        Path pathUserDir = Path.of(System.getProperty("user.dir"));
        Path pathIn = Path.of(pathUserDir + "\\res\\Exercises Resources\\inputLineNumbers.txt");
        Path pathOut = Path.of(pathUserDir + "\\res\\output.txt");

        try (BufferedReader bfr = Files.newBufferedReader(pathIn);
             BufferedWriter bfw = Files.newBufferedWriter(pathOut)){

            String line;
            int counter = 0;
            while (null != (line = bfr.readLine())){
                counter++;
                bfw.append(String.format("%d. ", counter))
                        .append(line)
                        .append(System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
