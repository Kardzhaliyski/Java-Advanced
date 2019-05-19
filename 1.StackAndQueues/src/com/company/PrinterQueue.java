package com.company;

import java.util.ArrayDeque;
import java.util.Scanner;

public class PrinterQueue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        var printerQueue = new ArrayDeque<String>();
        var output = new StringBuilder();

        while (true) {
            var input = sc.nextLine();

            if (input.toLowerCase().equals("print")) {
                break;
            }

            if (input.toLowerCase().equals("cancel")) {
                if (printerQueue.isEmpty()) {
                    output.append("Printer is on standby");
                    output.append(System.getProperty("line.separator"));

                } else {
                    output.append("Canceled ");
                    output.append(printerQueue.remove());
                    output.append(System.getProperty("line.separator"));

                }
            } else {
                printerQueue.add(input);
            }
        }

        while(!printerQueue.isEmpty()) {
            output.append(printerQueue.remove());
            output.append(System.getProperty("line.separator"));
        }

        System.out.println(output);
    }

}
