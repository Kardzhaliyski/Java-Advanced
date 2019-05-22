package com.company;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PoisonousPlants {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numOfPlants = Integer.parseInt(sc.nextLine());
        List<Integer> plants = Arrays
                .stream(sc
                        .nextLine()
                        .split("\\s+", numOfPlants))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        var days = 0;

        while (true) {
            var lastPlant = plants.get(0);
            var plantsRemoved = false;
            for (int i = 1; i < plants.size(); i++) {
                if(plants.get(i) == -1) {
                    continue;
                }

                if(plants.get(i) > lastPlant) {
                    lastPlant = plants.get(i);
                    plants.set(i, -1);
                    plantsRemoved = true;
                } else {
                    lastPlant = plants.get(i);
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