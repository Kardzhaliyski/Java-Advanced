package com.company;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class SimpleCalculator2 {
    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        var input = sc.nextLine();
        var numbers = new ArrayDeque<Integer>();
        var signs = new ArrayDeque<String>();
        int[] inputNums = Arrays.stream(input.split("\\D+"))
                .filter(e -> tryParseInt(e))
                .mapToInt(Integer::parseInt)
                .toArray();
        for (int i = inputNums.length - 1; i >= 0; i--) {
            numbers.push(inputNums[i]);
        }

        var inputSigns = Arrays.stream(input.split("\\d+"))
                .map(e -> e.replaceAll("\\s+", ""))
                .filter(e -> !e.isEmpty())
                .toArray(String[]::new);

        for (int i = inputSigns.length - 1; i >= 0; i--) {
            signs.push(inputSigns[i]);
        }


        while (numbers.size() > 1) {
            int num1 = numbers.pop();
            String operator = signs.pop();
            int num2 = numbers.pop();

            if (operator.equals("-")) {
                numbers.push((num1 - num2));
            } else if (operator.equals("+")) {
                numbers.push(num1 + num2 );
            }
        }

        System.out.println(numbers.peek());

    }

    static boolean tryParseInt(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
