package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class SumMatrixElements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        var dimensions = sc.nextLine().split(",\\s+");
        var rows = Integer.parseInt(dimensions[0]);
        var cols = Integer.parseInt(dimensions[1]);
        int sum = 0;
        int[][] matrix = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
           var curRowData =  Arrays.stream(sc
                    .nextLine()
                    .split(",\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
           matrix[row] = curRowData;
        }

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                sum += matrix[row][col];
            }
        }

        System.out.println(rows);
        System.out.println(cols);
        System.out.println(sum);

    }
}
