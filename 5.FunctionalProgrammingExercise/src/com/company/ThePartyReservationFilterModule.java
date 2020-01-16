package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ThePartyReservationFilterModule {
    public static void main(String[] args) {
        try (BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in))) {
            var guests = Arrays.stream(bfr.readLine().split("\\s+")).collect(Collectors.toList());

            var activeFilterStringList = new ArrayList<String>();

            String[] commandTokens;
            while (!((commandTokens = bfr.readLine().split(";", 2))[0]
                    .equalsIgnoreCase("Print"))) {

                if (commandTokens[0].equalsIgnoreCase("Add filter")) {
                    if (!activeFilterStringList.contains(commandTokens[1])) {
                        activeFilterStringList.add(commandTokens[1]);
                    }
                } else if (commandTokens[0].equalsIgnoreCase("Remove filter")) {
                    activeFilterStringList.remove(commandTokens[1]);
                }
            }

            ArrayList<Predicate<String>> activeFilterList = new ArrayList<>();
            for (String filterString : activeFilterStringList) {
                var filterTokens = filterString.split(";");
                activeFilterList.add(getFilter(filterTokens[0], filterTokens[1]));
            }

            for (Predicate<String> filter : activeFilterList) {
                guests.removeIf(filter);
            }

            System.out.println(String.join(" ", guests));


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Predicate<String> getFilter(String type, String parameter) {
        if (type.equalsIgnoreCase("starts with")) return s -> s.startsWith(parameter);
        else if (type.equalsIgnoreCase("ends with")) return s -> s.endsWith(parameter);
        else if (type.equalsIgnoreCase("length")) return s -> s.length() == Integer.parseInt(parameter);
        else return s -> s.contains(parameter);
    }
}
