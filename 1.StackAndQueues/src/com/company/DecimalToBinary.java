package com.company;

import java.util.ArrayDeque;
import java.util.Scanner;

public class DecimalToBinary {
    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        var num = Integer.parseInt(sc.nextLine());
        var numStack = new ArrayDeque<Integer>();

        do {
            numStack.push(num % 2);
            num /= 2;
        } while (num > 0);

        while(!numStack.isEmpty()){
            System.out.print(numStack.pop());
        }
    }
}
