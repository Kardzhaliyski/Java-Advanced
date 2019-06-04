package com.company;

import javax.swing.*;
import java.util.*;

public class LegendaryFarming {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, Integer> legendaryMats = new LinkedHashMap<>();
        legendaryMats.put("fragments", 0);
        legendaryMats.put("motes", 0);
        legendaryMats.put("shards", 0);
        Map<String, Integer> junkMats = new TreeMap<>();

        boolean legendaryObtained = false;
        while (!legendaryObtained) {
            var materialsObtained = sc.nextLine().split("\\s+");
            for (int i = 0; i < materialsObtained.length; i += 2) {
                var materialQuantity = Integer.parseInt(materialsObtained[i]);
                var materialType = materialsObtained[i + 1].toLowerCase();

                if (legendaryMats.containsKey(materialType)) {
                    legendaryMats.put(materialType, legendaryMats.get(materialType) + materialQuantity);
                    if (legendaryMats.get(materialType) >= 250) {
                        switch (materialType) {
                            case "shards": {
                                System.out.println("Shadowmourne obtained!");
                                legendaryObtained = true;
                                break;
                            }
                            case "fragments": {
                                System.out.println("Valanyr obtained!");
                                legendaryObtained = true;
                                break;
                            }
                            case "motes": {
                                System.out.println("Dragonwrath obtained!");
                                legendaryObtained = true;
                                break;
                            }
                        }

                        legendaryMats.put(materialType, legendaryMats.get(materialType) - 250);
                        break;
                    }
                } else {
                    junkMats.putIfAbsent(materialType, 0);
                    junkMats.put(materialType, junkMats.get(materialType) + materialQuantity);
                }
            }

        }

        legendaryMats.entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getValue, Comparator.reverseOrder()))
                .forEach(kvp -> {
                            System.out.println(String.format("%s: %d", kvp.getKey(), kvp.getValue()));
                        }
                );

        junkMats.forEach(((k, v) -> {
            System.out.println(String.format("%s: %d", k, v));
        }));
    }
}
