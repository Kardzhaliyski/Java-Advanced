package com.company;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SortLines {
    public static void main(String[] args) throws IOException {
        String userDir = System.getProperty("user.dir");

        Path pathIn = Path.of(userDir + "/res/input.txt");
        Path pathOut = Path.of(userDir + "/res/output.txt");

        List<String> inputLines = Files.readAllLines(pathIn)
                .stream()
                .filter(s -> !s.isEmpty())
                .sorted()
                .collect(Collectors.toList());
        Files.write(pathOut, inputLines);

    }
}
