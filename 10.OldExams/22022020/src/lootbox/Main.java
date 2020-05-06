package lootbox;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        try(BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in)) ) {
            var firstBoxArray = Arrays.stream(bfr.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            var secondBoxArray = Arrays.stream(bfr.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            var firstBoxQueue  = new ArrayDeque<Integer>();
            for (int i = 0; i < firstBoxArray.length; i++) {
                firstBoxQueue.offer(firstBoxArray[i]);
            }

            var secondBoxStack = new ArrayDeque<Integer>();
            for (int i = 0; i < secondBoxArray.length; i++) {
                secondBoxStack.push(secondBoxArray[i]);
            }

            var claimedItemSum = 0;
            while(!firstBoxQueue.isEmpty() && !secondBoxStack.isEmpty()) {
                var firstBoxItem = firstBoxQueue.peek();
                var secondBoxItem = secondBoxStack.peek();

                if((firstBoxItem + secondBoxItem) % 2 == 0) {
                    claimedItemSum += firstBoxItem + secondBoxItem;
                    firstBoxQueue.poll();
                    secondBoxStack.pop();
                } else {
                    firstBoxQueue.offer(secondBoxStack.poll());
                }
            }

            if(firstBoxQueue.isEmpty()){
                System.out.println("First lootbox is empty");
            } else {
                System.out.println("Second lootbox is empty");
            }

            if(claimedItemSum >= 100) {
                System.out.printf("Your loot was epic! Value: %s%n", claimedItemSum);
            } else {
                System.out.printf("Your loot was poor... Value: %s%n", claimedItemSum);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
