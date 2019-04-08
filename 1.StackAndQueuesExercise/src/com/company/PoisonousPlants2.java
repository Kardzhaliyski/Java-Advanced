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
        List<Integer> plants = Arrays
                .stream(sc
                        .nextLine()
                        .split("\\s+", numOfPlants))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        var days = 0;

        while (true) {
            var tempPlants = new ArrayList<Integer>();
            tempPlants.add(plants.get(0));
            for (int i = 1; i < plants.size(); i++) {
                if(plants.get(i) <= plants.get(i-1)){
                    tempPlants.add(plants.get(i));
                }
            }

            if(tempPlants.size() == plants.size()){
                break;
            }

            plants = tempPlants;
            days++;
        }

        System.out.println(days);

    }
}
