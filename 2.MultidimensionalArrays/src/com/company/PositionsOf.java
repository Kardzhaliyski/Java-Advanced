package com.company;

import java.util.Scanner;

public class PositionsOf {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        var dimentions = sc.nextLine().split("\\s+");
        var rows = Integer.parseInt(dimentions[0]);
        var cols = Integer.parseInt(dimentions[1]);
        var multiArr = new String[rows][];
        for (int row = 0; row < rows; row++) {
            multiArr[row] = sc.nextLine().split("\\s+");
        }

        var elemToFind = sc.nextLine();
        var elemFound = false;
        for (int row = 0; row < multiArr.length; row++) {
            for (int col = 0; col < multiArr[row].length; col++) {
                if(multiArr[row][col].equals(elemToFind)) {
                    System.out.println(row + " " + col);
                    elemFound = true;
                }
            }
        }

        if(!elemFound) {
            System.out.println("not found");
        }

    }
}
