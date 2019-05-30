package com.company;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        var input = sc.nextLine().toCharArray();
        var charCount = new TreeMap<Character, Integer>();
        for (char c : input) {
            charCount.putIfAbsent(c, 0);
            charCount.put(c, charCount.get(c) + 1);
        }

        for (Map.Entry<Character, Integer> entrySet : charCount.entrySet()) {
            System.out.println((entrySet.getKey() + ": " + entrySet.getValue() + " time/s"));
        }
    }
}
