package com.company;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindTheSmallestElement {
    public static void main(String[] args) {
        try (BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in))) {
            var numbers = Arrays.stream(bfr.readLine().split("\\s+"))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            Function<List<Integer>, Integer> findSmallestNumber = nums ->
                    nums.stream()
                            .min(Integer::compareTo)
                            .get();

            BiFunction<List<Integer>, Integer, Integer> lastIndexOf = List::lastIndexOf;

            System.out.println(lastIndexOf.apply(numbers, findSmallestNumber.apply(numbers)));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
