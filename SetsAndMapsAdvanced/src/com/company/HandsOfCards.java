package com.company;

import java.util.*;

public class HandsOfCards {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        var playerDecks = new LinkedHashMap<String, Set<String>>();
        var input = "";

        while (!"JOKER".equalsIgnoreCase(input = sc.nextLine())) {
            var data = input.split(": ");
            var playerName = data[0];
            var cards = data[1].split(", ");

            playerDecks.putIfAbsent(playerName, new HashSet<>());

            for (String card : cards) {
                playerDecks.get(playerName).add(card);
            }

        }

        for (Map.Entry<String, Set<String>> player : playerDecks.entrySet()) {
            int value = calculateDeckValue(player.getValue());
            System.out.println(player.getKey() + ": " + value);
        }

        System.out.println();
    }

    private static int calculateDeckValue(Set<String> deck) {
        var sum = 0;
        for (String card : deck) {
            var typeString = card.charAt(card.length() -1);
            var typeValue = 0;
            switch (typeString) {
                case 'C': {
                    typeValue = 1;
                    break;
                }
                case 'D': {
                    typeValue = 2;
                    break;
                }
                case 'H': {
                    typeValue = 3;
                    break;
                }
                case 'S': {
                    typeValue = 4;
                    break;
                }
            }

            var powerString = card.substring(0, card.length() -1);
            var powerValue = 0;
            switch (powerString) {
                case "J": {
                    powerValue = 11;
                    break;
                }
                case "Q": {
                    powerValue = 12;
                    break;
                }
                case "K": {
                    powerValue = 13;
                    break;
                }
                case "A": {
                    powerValue = 14;
                    break;
                }
                default: {
                    powerValue = Integer.parseInt(powerString);
                    break;
                }
            }

            sum += powerValue * typeValue;
        }


        return sum;
    }
}
