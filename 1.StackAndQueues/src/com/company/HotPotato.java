package com.company;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class HotPotato {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        var turnQueue = new ArrayDeque<String>();
        var playersInputArr = sc.nextLine().split("\\s+");
        Collections.addAll(turnQueue, playersInputArr);
        int removePerNTurns = Integer.parseInt(sc.nextLine());
        var output = new StringBuilder();

        while (turnQueue.size() > 1) {
            for (int i = 1; i < removePerNTurns; i++) {
                turnQueue.add(turnQueue.remove());
            }

            var removedPlayer = String.format("Removed " + turnQueue.remove() + "%n");
            output.append(removedPlayer);
        }

        output.append("Last is ");
        output.append(turnQueue.remove());

        System.out.println(output);
    }
}
