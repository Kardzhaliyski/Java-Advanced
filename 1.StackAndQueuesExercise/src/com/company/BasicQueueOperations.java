package com.company;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        var tokens = Arrays
                .stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        var numsToAdd = tokens[0];
        var numsToRemove = tokens[1];
        var numToFind = tokens[2];
        var numsInput = Arrays
                .stream(sc
                        .nextLine()
                        .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        var queue = new ArrayDeque<Integer>();

        if(numsInput.length < numsToAdd){
            numsToAdd = numsInput.length;
        }

        for (int i = 0; i < numsToAdd; i++) {
            queue.offer(numsInput[i]);
        }

        if(queue.size() < numsToRemove){
            numsToRemove = queue.size();
        }

        for (int i = 0; i < numsToRemove; i++) {
            queue.poll();
        }

        if(queue.contains(numToFind)){
            System.out.println("true");
        } else {
            printSmallestNumber(queue);
        }

    }

    private static void printSmallestNumber(ArrayDeque<Integer> queue) {
        if(queue.isEmpty()){
            System.out.println(0);
            return;
        }

        var queueCopy = queue.clone();
        int smallestNum = Integer.MAX_VALUE;
        while (!queueCopy.isEmpty()){
            var currNum = queueCopy.poll();
            if(smallestNum > currNum){
                smallestNum = currNum;
            }
        }

        System.out.println(smallestNum);
    }
}
