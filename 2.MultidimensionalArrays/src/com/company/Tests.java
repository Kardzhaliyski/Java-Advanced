package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Tests {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean[][] test = new boolean[8][8];

        System.out.println(test[0][1]);
        var testClone = new boolean[test.length][];
        for (int i = 0; i < testClone.length; i++) {
            testClone[i] = test[i].clone();
        }

        for (boolean[] row : test) {
            Arrays.fill(row, true);
        }
        System.out.println();
    }
}
