package com.company;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int commandsNumber = Integer.parseInt(sc.nextLine());
        StringBuilder currentString = new StringBuilder();
        Deque<StringBuilder> stringHistory = new ArrayDeque<>();
        for (int commandCounter = 0; commandCounter < commandsNumber; commandCounter++) {
            String[] tokens = sc.nextLine().split("\\s+", 2);
            String command = tokens[0];

            switch (command) {
                case "1": {
                    currentString.append(tokens[1]);
                    stringHistory.push(new StringBuilder(currentString));
                    break;
                }
                case "2": {
                    int charsToRemove = Integer.parseInt(tokens[1]);
                    if (charsToRemove > currentString.length()) {
                        charsToRemove = currentString.length();
                    } else if (charsToRemove < 0){
                        charsToRemove = 0;
                    }

                    int removeFromIndex = currentString.length() - charsToRemove;
                    currentString.delete(removeFromIndex, currentString.length());
                    stringHistory.push(new StringBuilder(currentString));
                    break;
                }
                case "3": {
                    int indexToPrint = Integer.parseInt(tokens[1]) -1;
                    if(indexToPrint >= 0 && indexToPrint < currentString.length()){
                        System.out.println(currentString.charAt(indexToPrint));
                    }
                    break;
                }
                case "4": {
                    stringHistory.pop();
                    if(stringHistory.isEmpty()){
                        currentString.setLength(0);
                    } else {
                        currentString = stringHistory.peek();
                    }

                    break;
                }
            }
        }
    }
}
