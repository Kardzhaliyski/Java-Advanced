package com.company;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        var cmnds = sc.nextLine().split("\\s+");
        var elemToPush = Integer.parseInt(cmnds[0]);
        var elemToPop = Integer.parseInt(cmnds[1]);
        var elemToCheck = Integer.parseInt(cmnds[2]);
        var inputElements = Arrays.stream(sc.nextLine().split("\\s+", elemToPush))
                .mapToInt(Integer::parseInt)
                .toArray();
        var numStack = new ArrayDeque<Integer>();

        for (int inputElement : inputElements) {
            numStack.push(inputElement);
        }

        for (int i = 0; i < elemToPop; i++) {
            if (!numStack.isEmpty()) {
                numStack.pop();
            }
        }

        if (numStack.size() == 0) {
            System.out.println(0);
        } else {

            var smallestElem = numStack.peek();
            var elemFound = false;
            while (!numStack.isEmpty() && !elemFound) {
                var currElem = numStack.pop();
                if (elemToCheck == currElem) {
                    elemFound = true;
                } else if (smallestElem > currElem) {
                    smallestElem = currElem;
                }
            }

            if (elemFound) {
                System.out.println(true);
            } else {
                System.out.println(smallestElem);
            }
        }

    }
}
