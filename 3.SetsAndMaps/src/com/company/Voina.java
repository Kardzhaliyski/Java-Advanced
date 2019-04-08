package com.company;

import java.util.*;
import java.util.stream.Collectors;

public class Voina {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        var firstPlayerDeck = Arrays.stream(sc.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));

        var secondPlayerDeck = Arrays.stream(sc.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));

        for (int round = 0; round < 50; round++) {
            if(firstPlayerDeck.size() == 0 || secondPlayerDeck.size() == 0){
                break;
            }

            var firstPlayerCard = firstPlayerDeck.iterator().next();
            var secondPlayerCard = secondPlayerDeck.iterator().next();
            firstPlayerDeck.remove(firstPlayerCard);
            secondPlayerDeck.remove(secondPlayerCard);

            if(firstPlayerCard > secondPlayerCard){
                firstPlayerDeck.add(firstPlayerCard);
                firstPlayerDeck.add(secondPlayerCard);
            } else if(firstPlayerCard < secondPlayerCard){
                secondPlayerDeck.add(firstPlayerCard);
                secondPlayerDeck.add(secondPlayerCard);
            } else {
                firstPlayerDeck.add(firstPlayerCard);
                secondPlayerDeck.add(secondPlayerCard);
            }
        }

        if(firstPlayerDeck.size() == secondPlayerDeck.size()){
            System.out.println("Draw!");
        } else if(firstPlayerDeck.size() < secondPlayerDeck.size()){
            System.out.println("Second player win!");
        } else {
            System.out.println("First player win!");
        }
    }
}
