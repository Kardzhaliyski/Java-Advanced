package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class SumNumbers {
    public static void main(String[] args) {
       try(BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in))) {
           Function<String, Integer> parseInt = str -> Integer.parseInt(str);
           var numbers = Arrays.stream(bfr.readLine().split(", ")).mapToInt(s -> parseInt.apply(s)).toArray();
           System.out.println("Count = " + numbers.length);
           System.out.println("Sum = " + Arrays.stream(numbers).sum());
       } catch (IOException e) {
           e.printStackTrace();
       }

    }
}