package com.company;

import java.util.HashSet;
import java.util.Scanner;

public class ParkingLot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        var parking = new HashSet<String>();
        while (true) {
            String[] input = sc.nextLine().split(", ");
            if (input[0].equals("END")) {
                break;
            }

            if (input[0].equals("IN")) {
                parking.add(input[1]);
            } else {
                parking.remove(input[1]);
            }
        }

        if (parking.size() == 0) {
            System.out.println("Parking Lot is Empty");
        } else {

            for (Object car : parking) {
                System.out.println(car);
            }
        }
    }
}
