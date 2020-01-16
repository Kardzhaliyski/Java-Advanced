package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateParty {
    public static void main(String[] args) {
        try (BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in))) {
            List<String> guests = Arrays.stream(bfr.readLine().split("\\s+")).collect(Collectors.toList());

            String[] tokens;
            while (!(tokens = bfr.readLine().split("\\s+"))[0].equalsIgnoreCase("Party!")) {
                var filter = getFilter(tokens);
                var command = tokens[0];
                executeCommand(guests,command, filter);
            }

            guests = guests.stream().sorted().collect(Collectors.toList());
            if(guests.isEmpty()) {
                System.out.println("Nobody is going to the party!");
            } else {
                var guestsJoin = String.join(", ", guests);
                System.out.println(guestsJoin + " are going to the party!");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void executeCommand(List<String> guests, String command, Predicate<String> filter) {
        if(command.equalsIgnoreCase("remove")) {
            guests.removeIf(filter);
        } else {
            var tempList = guests.stream().filter(filter).collect(Collectors.toList());
            guests.addAll(tempList);
        }
    }

    private static Predicate<String> getFilter(String[] tokens) {
        var command = tokens[1];
        if(command.equalsIgnoreCase("StartsWith")) {
            var startString = tokens[2];
            return n -> n.startsWith(startString);
        } else if(command.equalsIgnoreCase("EndsWith")) {
            var endString = tokens[2];
            return n -> n.endsWith(endString);
        } else if (command.equalsIgnoreCase("Length")) {
            var length = Integer.parseInt(tokens[2]);
            return n -> n.length() == length;
        }

        return null;
    }
}
