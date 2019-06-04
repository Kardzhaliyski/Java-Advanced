package com.company;

import java.util.*;

import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.toMap;

public class PopulationCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // country -> city/population
        // ordered by population , then by order they ware entered.

        var countryPopulation = new LinkedHashMap<String, Long>();
        var countryCityPopulation = new LinkedHashMap<String, LinkedHashMap<String, Long>>();

        var input = "";
        while (!"report".equalsIgnoreCase(input = sc.nextLine())) {
            // var data = input.split("[^\\s\\w]+");
            var data = input.split("[\\\\|]+");
            var city = data[0];
            var countryName = data[1];
            var population = Long.parseLong(data[2]);

            countryPopulation.putIfAbsent(countryName, 0L);
            countryPopulation.put(countryName,
                    countryPopulation.get(countryName) + population);

            countryCityPopulation.putIfAbsent(countryName, new LinkedHashMap<>());
            countryCityPopulation.get(countryName).put(city, population);
        }

        countryPopulation = countryPopulation
                .entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(toMap(e -> e.getKey(), e -> e.getValue(), (e1, e2) -> e2, LinkedHashMap::new));

        for (Map.Entry<String, LinkedHashMap<String, Long>> countrySet : countryCityPopulation.entrySet()) {

            var country = countrySet.getKey();
            var tempMap = countryCityPopulation
                    .get(country)
                    .entrySet()
                    .stream()
                    .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                    .collect(toMap(e -> e.getKey(), e -> e.getValue(), (e1, e2) -> e2, LinkedHashMap::new));
            countryCityPopulation.put(country, tempMap);
        }

        for (Map.Entry<String, Long> countryEntry : countryPopulation.entrySet()) {
            System.out.printf("%s (total population: %d)%n", countryEntry.getKey(), countryEntry.getValue());
            for (Map.Entry<String, Long> cityEntry : countryCityPopulation.get(countryEntry.getKey()).entrySet()) {
                System.out.printf("=>%s: %d%n", cityEntry.getKey(), cityEntry.getValue());
            }
        }



    }
}
