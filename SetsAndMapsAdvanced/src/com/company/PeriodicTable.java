package com.company;

import java.util.Scanner;
import java.util.TreeSet;

public class PeriodicTable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        var inputCount = Integer.parseInt(sc.nextLine());
        var elementSet = new TreeSet<String>();
        for (int i = 0; i < inputCount; i++) {
            var currInput = sc.nextLine().split("\\s+");
            for (String elem : currInput) {
                elementSet.add(elem);
            }
        }

        for (String elem : elementSet) {
            System.out.print(elem + " ");
        }
    }
}
