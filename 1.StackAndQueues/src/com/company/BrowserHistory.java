package com.company;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        var history = new ArrayDeque<String>();

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
                    history.pop();
                }
            } else {
                history.push(cmnd);
            }

            System.out.println(history.peek());
        }

    }
}
