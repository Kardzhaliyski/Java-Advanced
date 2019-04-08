package com.company;

import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class SoftuniParty {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        var reservations = new TreeSet<String>();
        while (true){
            var input = sc.nextLine();
            if(input.equals("PARTY")){
                break;
            }

            reservations.add(input);
        }

        while(true){
            var input = sc.nextLine();
            if(input.equals("END")){
                break;
            }

            reservations.remove(input);
        }

        System.out.println(reservations.size());
        for (String person : reservations) {
            System.out.println(person);
        }
    }
}
