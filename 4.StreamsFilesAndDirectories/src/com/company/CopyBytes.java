package com.company;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class CopyBytes {
    public static void main(String[] args) {
        String userDir = System.getProperty("user.dir");
        String pathInput = userDir + "/res/input.txt";
        String pathOutput = userDir + "/res/output.txt";

        try (FileInputStream fis = new FileInputStream(pathInput);
             FileOutputStream fos = new FileOutputStream(pathOutput)) {

            int oneByte = fis.read();
            while (oneByte >= 0) {
                String currChar = String.valueOf(oneByte);

                if (oneByte == 32 ||
                        oneByte == 10) {

                    fos.write(oneByte);
                } else {
                    for (int i = 0; i < currChar.length(); i++) {
                        fos.write(currChar.charAt(i));
                    }
                }

                oneByte = fis.read();
            }

        } catch (IOException e) {

        }
    }
}
