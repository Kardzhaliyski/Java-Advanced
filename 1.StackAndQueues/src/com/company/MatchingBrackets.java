package com.company;

import java.util.ArrayDeque;
import java.util.Scanner;

public class MatchingBrackets {
    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        var openBracedIndex = new ArrayDeque<Integer>();
        var inputString = sc.nextLine();

        for (int i = 0; i < inputString.length(); i++) {
            var currChar = inputString.charAt(i);
            if (currChar == '(') {
                openBracedIndex.push(i);
            } else if (currChar == ')') {
                System.out.println(inputString.substring(openBracedIndex.pop(), i + 1));
            }
        }


    }
}
