package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CountUppercaseWords {
    public static void main(String[] args) {
        try(BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in))){
            var inputString = bfr.readLine();
            Predicate<String> isUpperCase = n -> Character.isUpperCase(n.charAt(0));
            var upperCaseWords = Arrays.stream(inputString.split("\\s+"))
                    .filter(n -> isUpperCase.test(n))
                    .collect(Collectors.toList());
            System.out.println(upperCaseWords.size());
            upperCaseWords.forEach(n -> System.out.println(n));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
