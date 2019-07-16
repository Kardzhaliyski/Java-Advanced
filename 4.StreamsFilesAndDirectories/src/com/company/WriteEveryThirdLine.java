package com.company;

import java.io.*;

public class WriteEveryThirdLine {
    public static void main(String[] args) {

        String userDir = System.getProperty("user.dir");
        String pathIn = userDir + "/res/input.txt";
        String pathOut = userDir + "/res/output.txt";

        try (BufferedReader bfr = new BufferedReader(new FileReader(pathIn));
             BufferedWriter bfw = new BufferedWriter(new PrintWriter(pathOut))) {

            var lineNum = 1;
            String line = bfr.readLine();
            while (line != null) {
                if(lineNum % 3 == 0) {
                    bfw.append(line).append(System.lineSeparator());
                }

                line = bfr.readLine();
                lineNum++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
