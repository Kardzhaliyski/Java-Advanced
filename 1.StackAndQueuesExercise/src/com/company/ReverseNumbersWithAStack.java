package com.company;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class ReverseNumbersWithAStack {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        var numberArr = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        var numStack = new ArrayDeque<Integer>();
        for (int num : numberArr) {
            numStack.push(num);
        }

        for (int i = 0; i < numberArr.length; i++) {
            numberArr[i] = numStack.pop();
        }

        for (int num : numberArr) {
            System.out.print(num + " ");
        }
    }
}
