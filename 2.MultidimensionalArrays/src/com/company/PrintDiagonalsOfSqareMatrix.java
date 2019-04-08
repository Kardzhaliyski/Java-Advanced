package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class PrintDiagonalsOfSqareMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        var size = Integer.parseInt(sc.nextLine());
        var matrix = new int[size][size];
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = Arrays
                    .stream(sc
                            .nextLine()
                            .split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        for (int index = 0; index < matrix.length; index++) {
            System.out.print(matrix[index][index] + " ");
        }
        System.out.println();

        for (int index = 0; index < matrix.length; index++) {
            System.out.print(matrix[matrix.length -1 -index][index] + " ");
        }
    }
}
