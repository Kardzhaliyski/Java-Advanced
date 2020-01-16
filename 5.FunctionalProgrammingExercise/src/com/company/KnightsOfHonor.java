package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Consumer;

public class KnightsOfHonor {
    public static void main(String[] args) {
        try (BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in))) {
            Consumer<String> printHonorableAndName = name -> System.out.printf("Sir %s%n", name);
            Arrays.stream(bfr.readLine().split("\\s+"))
                    .forEach(printHonorableAndName);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
