package com.company;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class PoisonousPlants {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfPlants = Integer.parseInt(sc.nextLine());
        var plantInput = Arrays
                .stream(sc
                        .nextLine()
                        .split("\\s+", numberOfPlants))
                .mapToInt(Integer::parseInt)
                .toArray();
        Deque<Integer> alivePlants = new ArrayDeque<>();

        populateQueue(plantInput,alivePlants);

        int day = 0;
        while(true){
            boolean anyDiedToday = checkForDeadPlants(alivePlants);
            if(anyDiedToday){
                day++;
            } else {
                break;
            }
        }

        System.out.println(day);

    }

    private static void populateQueue(int[] plantInput, Deque<Integer> alivePlants) {
        for (int plant : plantInput) {
            alivePlants.offer(plant);
        }
    }

    private static boolean checkForDeadPlants(Deque<Integer> alivePlants) {
        var anyDiedToday = false;
        var lastPlantChecked = Integer.MAX_VALUE;
        var plantsCount = alivePlants.size();
        for (int i = 0; i < plantsCount; i++) {
            var currPlant = alivePlants.poll();
            if(currPlant < lastPlantChecked){
                alivePlants.offer(currPlant);
            } else {
                anyDiedToday = true;
            }

            lastPlantChecked = currPlant;
        }

        return anyDiedToday;
    }

}
