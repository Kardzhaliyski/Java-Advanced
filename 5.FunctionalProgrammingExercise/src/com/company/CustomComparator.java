package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class CustomComparator {
    public static void main(String[] args) {
        try (BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in))) {
            var numbers = Arrays.stream(bfr.readLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
            Comparator<Integer> comparator = (f, s) -> {
                if ((f % 2 == 0 && s % 2 != 0)) {
                    return -1;
                } else if (f % 2 != 0 && s % 2 == 0) {
                    return 1;
                } else {
                    return f - s;
                }
            };

            numbers.sort(comparator);
            System.out.println(numbers);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
