package com.company;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BalanceParentheses {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        var input = sc.nextLine().toCharArray();
        var parrenthesesQueue = new ArrayDeque<Character>();
        for (char ch : input) {
            if(ch == '{' || ch == '[' || ch == '(') {
                parrenthesesQueue.push(ch);
            } else if (parrenthesesQueue.isEmpty()) {
                System.out.println("NO");
                return;
            } else {
                if(ch == '}' && parrenthesesQueue.pop() != '{') {
                    System.out.println("NO");
                    return;
                } else if (ch == ']' && parrenthesesQueue.pop() != '[') {
                    System.out.println("NO");
                    return;
                } else if (ch == ')' && parrenthesesQueue.pop() != '(') {
                    System.out.println("NO");
                    return;
                }
            }
        }

        if(parrenthesesQueue.isEmpty()) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
