package com.company;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        var cmnds = sc.nextLine().split("\\s+");
        var inputNumsArr = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        var elemsToOffer = Integer.parseInt(cmnds[0]);
        if (elemsToOffer > inputNumsArr.length) {
            elemsToOffer = inputNumsArr.length;
        }

        var numsQueue = new ArrayDeque<Integer>();
        for (int i = 0; i < elemsToOffer; i++) {
            numsQueue.offer(inputNumsArr[i]);
        }

        var elemsToDeque = Integer.parseInt(cmnds[1]);
        for (int i = 0; i < elemsToDeque; i++) {
            numsQueue.poll();
        }

        if (!numsQueue.isEmpty()) {
            var numToCheck = Integer.parseInt(cmnds[2]);
            var smallestNum = numsQueue.peek();
            var numFound = false;

            while (!numsQueue.isEmpty()) {
                var currNum = numsQueue.poll();
                if (numToCheck == currNum) {
                    numFound = true;
                    break;
                } else if (smallestNum > currNum) {
                    smallestNum = currNum;
                }
            }

            if(numFound) {
                System.out.println(true);
            } else {
                System.out.println(smallestNum);
            }
        } else {
            System.out.println(0);
        }

    }
}
