package com.company;

import java.util.ArrayDeque;
import java.util.Scanner;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        var commandsCount = Integer.parseInt(sc.nextLine());
        var numberStack = new ArrayDeque<Integer>();

        for (int i = 0; i < commandsCount; i++) {
            var command = sc.nextLine().split(" ");

            if (command[0].equals("1")) {
                var number = Integer.parseInt(command[1]);
                numberStack.push(number);
            } else if (command[0].equals("2")) {
                numberStack.pop();
            } else if (command[0].equals("3")){
                printMaxNum(numberStack);
            }
        }
    }

    private static void printMaxNum(ArrayDeque<Integer> numberStack) {
        var sortedArray = numberStack
                .stream()
                .sorted((a,b) -> b.compareTo(a))
                .mapToInt(Integer::intValue)
                .toArray();
        System.out.println(sortedArray[0]);
    }
}
