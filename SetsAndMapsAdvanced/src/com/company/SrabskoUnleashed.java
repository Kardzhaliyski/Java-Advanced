package com.company;

import com.sun.jdi.Value;

import java.util.*;
import java.util.stream.Collectors;

public class SrabskoUnleashed {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, Map<String, Integer>> concerts = new LinkedHashMap<>();

        var input = "";
        while (!"End".equals(input = sc.nextLine())) {
            var data = input.split(" ");
            if (data.length < 4) {
                continue;
            }

            var venue = "";
            var singer = "";
            var ticketPrice = 0;
            var ticketQuantity = 0;

            if (data.length == 4) {
                if (data[1].charAt(0) != '@') {
                    continue;
                }

                venue = data[1].substring(1);
                singer = data[0];

                ticketPrice = tryParseInt(data[2]);
                ticketQuantity = tryParseInt(data[3]);

            } else {
                singer += data[0];
                var venueIndex = -1;
                for (int i = 1; i < data.length - 2; i++) {
                    if (data[i].charAt(0) != '@') {
                        singer += " " + data[i];
                    } else {
                        venueIndex = i;
                        break;
                    }
                }

                if (venueIndex <= 0) {
                    continue;
                }

                for (int i = venueIndex; i < data.length - 2; i++) {
                    if (i == venueIndex) {
                        venue = data[i].substring(1);
                    } else {
                        venue += " " + data[i];
                    }
                }

                ticketPrice = tryParseInt(data[data.length - 2]);
                ticketQuantity = tryParseInt(data[data.length - 1]);
            }

            if(ticketPrice < 0 || ticketQuantity < 0) {
                continue;
            }

            concerts.putIfAbsent(venue, new LinkedHashMap<>());
            concerts.get(venue).putIfAbsent(singer, 0);
            concerts.get(venue).put(singer, concerts.get(venue).get(singer) + ticketPrice * ticketQuantity);
        }

        for (Map.Entry<String, Map<String, Integer>> concertKvp : concerts.entrySet()) {
            System.out.println(concertKvp.getKey());
            concertKvp.getValue().entrySet().stream()
                    .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                    .forEach(kvp -> {
                        System.out.println(String.format("#  %s -> %d",
                                kvp.getKey(),
                                kvp.getValue()));
                    });
        }
    }

    private static int tryParseInt(String num) {
        try {
            return Integer.parseInt(num);
        } catch (NumberFormatException e) {
            return -1;
        }

    }
}
