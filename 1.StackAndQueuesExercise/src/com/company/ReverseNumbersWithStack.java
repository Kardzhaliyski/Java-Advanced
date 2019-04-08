package com.company;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class ReverseNumbersWithStack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] numbersInput = sc.nextLine().split(" ");
        var numbersStack = new ArrayDeque<String>();
        for (String num : numbersInput) {
            numbersStack.push(num);
        }

        while(!numbersStack.isEmpty()){
            System.out.print(numbersStack.pop() + " ");
        }
    }
}
