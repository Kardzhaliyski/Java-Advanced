package com.company;

import java.util.Scanner;

public class MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        var inputSides = sc.nextLine().split("\\s+");
        var rows = Integer.parseInt(inputSides[0]);
        var cols = Integer.parseInt(inputSides[1]);
        var matrix = new String[rows][cols];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = "" + (char)('a' + row) + (char)('a' + col + row) + (char)('a' + row);
            }
        }

        for (String[] row : matrix) {
            for (String elem : row) {
                System.out.print(elem + " ");
            }

            System.out.println();
        }

    }
}
