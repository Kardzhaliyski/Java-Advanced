package com.company;

import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        var numOfCmnds = Integer.parseInt(sc.nextLine());
        var textStack = new ArrayDeque<String>();
        textStack.push("");

        for (int i = 0; i < numOfCmnds; i++) {
            var cmndInput = sc.nextLine().split("\\s+");
            var cmnd = cmndInput[0];

            switch (cmnd) {
                case "1": {
                    var textToAppend = cmndInput[1];
                    textStack.push(textStack.peek() + textToAppend);
                    break;
                }
                case "2": {
                    var currString = textStack.peek();
                    var numCharsToErase = Integer.parseInt(cmndInput[1]);

                    if (numCharsToErase > currString.length()) {
                        numCharsToErase = currString.length();
                    }

                    currString = currString.substring(0, currString.length() - numCharsToErase);
                    textStack.push(currString);
                    break;
                }
                case "3": {
                    var currString = textStack.peek();
                    var charIndex = Integer.parseInt(cmndInput[1]) -1;
                    if (charIndex >= 0 && charIndex < currString.length()) {
                        System.out.println(currString.charAt(charIndex));
                    }

                    break;
                }
                case "4": {
                    if(textStack.size() > 1) {
                        textStack.pop();
                    }
                    break;
                }
            }
        }
    }
}
