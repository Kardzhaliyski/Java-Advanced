package com.company;

import java.util.Scanner;

public class PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        var dimensions = Integer.parseInt(sc.nextLine());
        var matrix = new String[dimensions][];

        for (int row = 0; row < matrix.length; row++) {
            var currRowInput = sc.nextLine().split("\\s+", dimensions);
            matrix[row] = currRowInput;
        }

        for (int i = 0; i < matrix.length; i++) {
            System.out.print(matrix[i][i] + " ");
        }

        System.out.println();

        for (int i = 0; i < matrix.length; i++) {
            System.out.print(matrix[matrix.length -1 - i][i] + " ");
        }

    }
}
