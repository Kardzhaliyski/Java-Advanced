package com.company;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        var numbers = Arrays.stream(sc.nextLine().split(" "))
                .mapToDouble(Double::parseDouble)
                .map(e -> Math.round(e * 10) / 10.0)
                .toArray();
        var numbersCount = new LinkedHashMap<Double, Integer>();
        for (double number : numbers) {
            numbersCount.putIfAbsent(number, 0);
            numbersCount.put(number, numbersCount.get(number) + 1);
        }
        for (Map.Entry<Double, Integer> entry : numbersCount.entrySet()) {
            System.out.printf("%.1f -> %d%n", entry.getKey(), entry.getValue());
        }
    }
}
