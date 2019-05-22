package com.company;

import java.util.ArrayDeque;
import java.util.Scanner;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        var numOfCommands = Integer.parseInt(sc.nextLine());
        var maxNum = 0;
        var numStack = new ArrayDeque<Integer>();
        for (int i = 0; i < numOfCommands; i++) {
            var cmnd = sc.nextLine().split("\\s+");

            switch (cmnd[0]) {
                case "1": {
                    var currNum = Integer.parseInt(cmnd[1]);
                    numStack.push(currNum);

                    if (currNum > maxNum && maxNum >= 0) {
                        maxNum = currNum;
                    }

                    break;
                }
                case "2": {
                    if (!numStack.isEmpty()) {
                        if (maxNum == numStack.pop()) {
                            maxNum = -1;
                        }
                    }
                    break;
                }
                case "3": {
                    if (maxNum > 0) {
                        System.out.println(maxNum);
                    } else if (numStack.isEmpty()) {
                        System.out.println(0);
                    } else {
                        maxNum = findMaxNum(numStack);
                        System.out.println(maxNum);
                    }
                }
            }
        }

    }

    private static int findMaxNum(ArrayDeque<Integer> numStack) {
        var maxNum = 0;
        var numStackCopy = numStack.clone();
        while (!numStackCopy.isEmpty()) {
            var currNum = numStackCopy.pop();
            if(maxNum < currNum) {
                maxNum = currNum;
            }
        }

        return maxNum;
    }
}
