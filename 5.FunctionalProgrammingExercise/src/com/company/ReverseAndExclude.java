package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ReverseAndExclude {
    public static void main(String[] args) {
        try (BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in))) {
            List<Integer> numbers = Arrays.stream(bfr.readLine().split("\\s+"))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            var divisor = Integer.parseInt(bfr.readLine());
            BiConsumer<List<Integer>,Integer> removeDivisibleNumbers = (l,d) -> l.removeIf(n -> n % d == 0);
            removeDivisibleNumbers.accept(numbers, divisor);

            Function<List<Integer>, List<Integer>> reverseList = l ->  {
                var tempList = new ArrayList<Integer>();
                for (int i = l.size() - 1; i >= 0; i--) {
                    tempList.add(l.get(i));
                }

                return tempList;
            };

            numbers = reverseList.apply(numbers);

            Consumer<List<Integer>> printer = l -> l.forEach(n -> System.out.print(n + " "));
            printer.accept(numbers);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
