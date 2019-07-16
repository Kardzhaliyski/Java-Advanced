package com.company;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class ExtractIntegers {
    public static void main(String[] args) {
        String userDir = System.getProperty("user.dir");
        String pathIn = userDir + "/res/input.txt";
        String pathOut = userDir + "/res/output.txt";

        try (Scanner scanner = new Scanner(new FileReader(pathIn));
             PrintWriter writer = new PrintWriter(pathOut)) {
            while (scanner.hasNext()) {
                scanner.next();
                if (scanner.hasNextInt()) {
                    writer.println(scanner.nextInt());
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
