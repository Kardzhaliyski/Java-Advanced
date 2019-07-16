package com.company;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class WriteToFile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String userDir = System.getProperty("user.dir");
        String pathInput = userDir + "/res/input.txt";
        String pathOutput = userDir + "/res/output.txt";
        System.out.println();

        try (FileInputStream fis = new FileInputStream(pathInput);
             FileOutputStream fos = new FileOutputStream(pathOutput)) {

            int oneByte = fis.read();
            Set<Integer> charsToSkip = new HashSet<>();
            charsToSkip.add((int)',');
            charsToSkip.add((int)'.');
            charsToSkip.add((int)'!');
            charsToSkip.add((int)'?');
            System.out.println();


            while (oneByte >= 0) {
                oneByte = fis.read();
                if(!charsToSkip.contains(oneByte)){
                    fos.write(oneByte);
                }
            }
            System.out.println();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
}
