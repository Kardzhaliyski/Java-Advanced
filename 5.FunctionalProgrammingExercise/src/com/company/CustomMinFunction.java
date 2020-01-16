package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Function;

public class CustomMinFunction {
    public static void main(String[] args) {
        try (BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in))) {
            Function<Integer[], Integer> getMin = e -> {
                int minNum = Integer.MAX_VALUE;
                for (Integer num : e) {
                    if(num < minNum ) minNum = num;
                }

                return minNum;
            };

            Integer[] numbers = Arrays.stream(bfr.readLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .boxed()
                    .toArray(Integer[]::new);

            var minNum = getMin.apply(numbers);
            System.out.println(minNum);



        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
