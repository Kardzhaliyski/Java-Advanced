package com.company;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        var tokens = sc.nextLine().split(" ");
        var numToRead = Integer.parseInt(tokens[0]);
        var numToPop = Integer.parseInt(tokens[1]);
        var numToCheck = Integer.parseInt(tokens[2]);
        var numberStack = new ArrayDeque<Integer>();

        var inputNums = Arrays
                .stream(sc
                        .nextLine()
                        .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int i = 0; i < numToRead; i++) {
            numberStack.push(inputNums[i]);
        }

        if(numToPop > numberStack.size()){
            numToPop = numberStack.size();
        }

        for (int i = 0; i < numToPop; i++) {
            numberStack.pop();
        }

        if (numberStack.contains(numToCheck)) {
            System.out.println("true");
        } else if(!numberStack.isEmpty()){
            int smallestNum = getSmallestNumber(numberStack);
            System.out.println(smallestNum);
        } else {
            System.out.println(0);
        }

    }

    private static Integer getSmallestNumber(ArrayDeque<Integer> numberStack) {
        var sortedNum = numberStack
                .stream()
                .sorted((a,b) -> a.compareTo(b))
                .mapToInt(Integer::intValue)
                .toArray();
        return  sortedNum[0];
    }
}
