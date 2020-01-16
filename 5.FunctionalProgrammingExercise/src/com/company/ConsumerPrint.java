package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Consumer;

public class ConsumerPrint {
    public static void main(String[] args) {
        try (BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in))) {
            Consumer<String> printer = System.out::println;
            Arrays.stream(bfr.readLine().split("\\s+"))
                    .forEach(printer);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
