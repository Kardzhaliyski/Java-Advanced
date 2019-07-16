package com.company;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class WordCounter {
    public static void main(String[] args) {
        Path userdir = Path.of(System.getProperty("user.dir"));
        Map<String, Integer> wordCount = new HashMap<>();

        try (BufferedReader bfr = Files.newBufferedReader(Path.of(userdir + "\\res\\words.txt"))) {
            String[] words = bfr.readLine().split("\\W+");
            for (int i = 0; i < words.length; i++) {
                wordCount.putIfAbsent(words[i], 0);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader bfrText = Files.newBufferedReader(Path.of(userdir + "\\res\\text.txt"))) {
            String line;
            while ((line = bfrText.readLine()) != null) {
                String[] wordsInLine = line.split("\\W+");
                for (int i = 0; i < wordsInLine.length; i++) {
                    var word = wordsInLine[i];
                    if (wordCount.containsKey(word)) {
                        wordCount.put(word, wordCount.get(word) + 1);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Map<String, Integer> sortedWordCount = wordCount.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        try (BufferedWriter bfr = Files.newBufferedWriter(Path.of(userdir + "\\res\\results.txt"))) {
            for (Map.Entry<String, Integer> kvp : sortedWordCount.entrySet()) {
                bfr.append(String.format("%s - %d%n", kvp.getKey(), kvp.getValue()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
