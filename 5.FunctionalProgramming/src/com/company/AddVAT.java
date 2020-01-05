package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.UnaryOperator;

public class AddVAT {
    public static void main(String[] args) {
        try (BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in))) {
            var numbers = Arrays.stream(bfr.readLine().split(", ")).mapToDouble(Double::parseDouble).toArray();
            UnaryOperator<Double> addVAT = value -> value * 1.2;
            var numbersWithVat = Arrays.stream(numbers).map(n -> addVAT.apply(n)).toArray();
            System.out.println("Prices with VAT:");
            for (double num : numbersWithVat) {
                System.out.printf("%.2f%n", num);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
