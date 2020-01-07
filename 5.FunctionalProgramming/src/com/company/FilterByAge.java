package com.company;

import org.w3c.dom.ls.LSOutput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FilterByAge {
    public static void main(String[] args) {
        try(BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in))) {
            var numOfInputs = Integer.parseInt(bfr.readLine());
            Map<String, Integer> nameAgePairs = new LinkedHashMap<>();
            for (int i = 0; i < numOfInputs; i++) {
                var split = bfr.readLine().split(", ");
                int age = Integer.parseInt(split[1]);
                nameAgePairs.put(split[0], age);
            }

            var condition = bfr.readLine();
            var conditionAge = Integer.parseInt(bfr.readLine());
            var format = bfr.readLine();

            System.out.println();
            var filter = getFilter(condition, conditionAge);
            Consumer<Map.Entry<String, Integer>> printer = getPrinter(format);
            nameAgePairs.entrySet()
                    .stream()
                    .filter(e -> filter.test(e.getValue()))
                    .forEach(e -> printer.accept(e));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Consumer<Map.Entry<String, Integer>> getPrinter(String format) {
        Consumer<Map.Entry<String, Integer>> printer = null;
        if(format.equals("name")) {
            printer = e -> System.out.println(e.getKey());
        } else if (format.equals("age")) {
            printer = e -> System.out.println(e.getValue());
        } else {
            printer = e -> System.out.println(e.getKey() + " - " + e.getValue());
        }

        return printer;
    }


    private static Predicate<Integer> getFilter(String condition, Integer age) {
        Predicate<Integer> result = null;

        if(condition.equals("younger")) {
            result = n -> n <= age;
        } else {
            result = n -> n >= age;
        }

        return result;
    }
}
