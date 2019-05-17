package com.company;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        var input = sc.nextLine().split("\\s+");
        var numbers = new ArrayDeque<String>();
        Collections.addAll(numbers, input);

        while (numbers.size() > 1) {
            int num1 = Integer.parseInt(numbers.pop());
            String operator = numbers.pop();
            int num2 = Integer.parseInt(numbers.pop());

            if (operator.equals("-")) {
                numbers.push((num1 - num2) + "");
            } else if (operator.equals("+")) {
                numbers.push(num1 + num2 + "");
            }
        }

        System.out.println(numbers.peek());

    }
}
