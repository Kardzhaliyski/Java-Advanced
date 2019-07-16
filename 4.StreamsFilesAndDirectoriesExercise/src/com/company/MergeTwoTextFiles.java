package com.company;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class MergeTwoTextFiles {
    public static void main(String[] args) {
        Path userDir = Path.of(System.getProperty("user.dir"));

        try (BufferedReader bfr1 = Files.newBufferedReader(Path.of(userDir + "\\res\\inputOne.txt"));
             BufferedReader bfr2 = Files.newBufferedReader(Path.of(userDir + "\\res\\inputTwo.txt"));
             BufferedWriter bfw = Files.newBufferedWriter(Path.of(userDir + "\\res\\mergetText.txt"))) {

            String line;
            while ((line = bfr1.readLine()) != null) {
                bfw.append(line).append(System.lineSeparator());
            }

            while ((line = bfr2.readLine()) != null) {
                bfw.append(line).append(System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
