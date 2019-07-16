package com.company;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CountCharacterTypes {
    public static void main(String[] args) {
        Path userDir = Path.of(System.getProperty("user.dir"));
        Path pathIn = Path.of(userDir + "\\res\\input.txt");
        Path pathOut = Path.of(userDir + "\\res\\output.txt");

        try (BufferedReader bfr = Files.newBufferedReader(pathIn);
             BufferedWriter bfw = Files.newBufferedWriter(pathOut)) {
            int vowelCounter = 0;
            int consonantsCounter = 0;
            int punctuationCounter = 0;
            Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));;
            Set<Character> punctuations = new HashSet<>(Arrays.asList('.', ',', '!', '?'));;

            String line;
            while (null != (line = bfr.readLine())) {
                for (int i = 0; i < line.length(); i++) {
                    var currChar = line.charAt(i);
                    if (!Character.isWhitespace(currChar)) {
                        if(vowels.contains(currChar)) {
                            vowelCounter++;
                        } else if(punctuations.contains(currChar)) {
                            punctuationCounter++;
                        } else {
                            consonantsCounter++;
                        }
                    }
                }
            }

            bfw.append(String.format("Vowels: %d%n", vowelCounter))
                    .append(String.format("Consonants: %d%n", consonantsCounter))
                    .append(String.format("Punctuation: %d%n", punctuationCounter));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
