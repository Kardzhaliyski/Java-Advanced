package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class FindEvensOrOdds {
    public static void main(String[] args) {
        try (BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in))) {

            var boundaries = Arrays.stream(bfr.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            String condition = bfr.readLine();
            Predicate<Integer> filter = getFilter(condition);

            IntStream.range(boundaries[0], boundaries[1] +1)
                    .filter(filter::test)
                    .forEach(n ->System.out.print(n + " "));

        } catch (IOException e) {
                    e.printStackTrace();
        }

    }

    private static Predicate<Integer> getFilter(String condition) {
        Predicate<Integer> filter;
        if(condition.equals("odd")) {
            filter = num -> num % 2 != 0;
        } else {
            filter = num -> num % 2 == 0;
        }
        return filter;
    }
}
