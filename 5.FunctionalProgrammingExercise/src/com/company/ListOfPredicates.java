package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class ListOfPredicates {
    public static void main(String[] args) {
        try (BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in))) {
            var maxNum = Integer.parseInt(bfr.readLine());
            var divisors = Arrays.stream(bfr.readLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            List<Predicate<Integer>> predicateList = new ArrayList<>();

            for (int currDivisor : divisors) {
                predicateList.add(n -> n % currDivisor == 0);
            }

            for (int currNum = 1; currNum <= maxNum; currNum++) {
                var isDividable = true;
                for (Predicate<Integer> integerPredicate : predicateList) {
                    if (!integerPredicate.test(currNum)) {
                        isDividable = false;
                        break;
                    }
                }

                if(isDividable) System.out.print(currNum + " ");
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
