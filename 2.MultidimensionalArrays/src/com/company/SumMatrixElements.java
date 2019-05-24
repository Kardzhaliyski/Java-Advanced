package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class SumMatrixElements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        var dimentions = sc.nextLine().split(", ");
        var rows = Integer.parseInt(dimentions[0]);
        var cols = Integer.parseInt(dimentions[1]);
        var matrix = new int[rows][];

        for (int row = 0; row < rows; row++) {
            matrix[row] = Arrays.stream(sc.nextLine().split(", "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        System.out.println(rows);
        System.out.println(cols);
        System.out.println(sumMatrix(matrix));
    }

    private static int sumMatrix(int[][] matrix) {
        var sum = 0;

        for (int[] row : matrix) {
            for (int elem : row) {
                sum += elem;
            }
        }

        return sum;
    }
}
