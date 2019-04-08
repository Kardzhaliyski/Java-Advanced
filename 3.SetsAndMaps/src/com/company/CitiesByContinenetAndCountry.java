package com.company;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CitiesByContinenetAndCountry {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        var continents = new LinkedHashMap<String, LinkedHashMap<String, ArrayList<String>>>();

        var numOfInputs = Integer.parseInt(sc.nextLine());
        for (int inptCounter = 0; inptCounter < numOfInputs; inptCounter++) {
            var inputData = sc.nextLine().split("\\s+");
            var continentName = inputData[0];
            var countryName = inputData[1];
            var cityName = inputData[2];

            continents
                    .putIfAbsent(continentName, new LinkedHashMap<>());
            continents
                    .get(continentName)
                    .putIfAbsent(countryName, new ArrayList<>());
            continents
                    .get(continentName)
                    .get(countryName)
                    .add(cityName);
        }

        for (Map.Entry<String, LinkedHashMap<String, ArrayList<String>>> continent : continents.entrySet()) {
            System.out.printf("%s:%n",
                    continent.getKey());

            for (Map.Entry<String, ArrayList<String>> country : continent.getValue().entrySet()) {
                System.out.printf("  %s -> %s%n",
                        country.getKey(),
                        String.join(", ", country.getValue()));
            }

        }
    }
}
