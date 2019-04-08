package com.company;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Deque<Character> parrStack = new ArrayDeque<>();
        char[] inputChar = sc.nextLine().toCharArray();
        for (char currChar : inputChar) {
            if (currChar == '(' || currChar == '{' || currChar == '[') {
                parrStack.push(currChar);
            } else {
                if (parrStack.isEmpty()) {
                    System.out.println("NO");
                    return;
                }

                var lastOpen = parrStack.pop();
                if (currChar == ')' && lastOpen != '(') {
                    System.out.println("NO");
                    return;
                } else if (currChar == ']' && lastOpen != '[') {
                    System.out.println("NO");
                    return;
                } else if (currChar == '}' && lastOpen != '{') {
                    System.out.println("NO");
                    return;
                }

            }
        }

        System.out.println("YES");
    }
}
