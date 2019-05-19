package com.company;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistoryUpdate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        var history = new ArrayDeque<String>();
        var forwardHistory = new ArrayDeque<String>();

        while (true) {
            String cmnd = sc.nextLine();

            if (cmnd.toLowerCase().equals("home")) {
                break;
            }

            if (cmnd.toLowerCase().equals("back")) {
                if (history.size() <= 1) {
                    System.out.println("no previous URLs");
                    continue;
                } else {
                    forwardHistory.push(history.pop());
                }
            } else if (cmnd.toLowerCase().equals("forward")) {
                if(forwardHistory.size() == 0) {
                    System.out.println("no next URLs");
                    continue;
                } else {
                    history.push(forwardHistory.pop());
                }
            } else {
                history.push(cmnd);
                forwardHistory.clear();
            }

            System.out.println(history.peek());
        }

    }
}
