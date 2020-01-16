package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateForNames {
    public static void main(String[] args) {
        try (BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in))) {
            var maxNameLength = Integer.parseInt(bfr.readLine());
            var names = Arrays.stream(bfr.readLine().split("\\s+")).collect(Collectors.toList());

            Predicate<String> nameLengthValidator = s -> s.length() <= maxNameLength;
            names.removeIf(n -> !nameLengthValidator.test(n));

            names.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
