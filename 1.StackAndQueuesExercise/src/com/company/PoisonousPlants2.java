package com.company;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PoisonousPlants2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numOfPlants = Integer.parseInt(sc.nextLine());
        var plants = Arrays
                .stream(sc
                        .nextLine()
                        .split("\\s+", numOfPlants))
                .mapToInt(Integer::parseInt)
                .toArray();
        var days = 0;

        var lastPlant = plants[0];
        var plantsRemoved = false;

        while (true) {
            lastPlant = plants[0];
            plantsRemoved = false;

            for (int i = 1; i < plants.length; i++) {
                if(plants[i] == -1) {
                    continue;
                }

                if(plants[i] > lastPlant) {
                    lastPlant = plants[i];
                    plants[i] = -1;
                    plantsRemoved = true;
                } else {
                    lastPlant = plants[i];
                }

            }

            if(!plantsRemoved){
                break;
            }

            days++;
        }

        System.out.println(days);

    }
}