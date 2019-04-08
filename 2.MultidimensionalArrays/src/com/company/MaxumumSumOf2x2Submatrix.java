package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class MaxumumSumOf2x2Submatrix {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        var dimensions = sc.nextLine().split(",\\s+");
        var rows = Integer.parseInt(dimensions[0]);
        var cols = Integer.parseInt(dimensions[1]);
        int[][] matrix = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            var curRowData = Arrays.stream(sc
                    .nextLine()
                    .split(",\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix[row] = curRowData;
        }

        printMaxSumSubmatrix(matrix);


    }

    private static void printMaxSumSubmatrix(int[][] matrix) {
        var maxSum = Integer.MIN_VALUE;
        var rowOne = "";
        var rowTwo = "";

        for (int row = 0; row < matrix.length - 1; row++) {
            for (int col = 0; col < matrix[row].length - 1; col++) {
                var currNum1 = matrix[row][col];
                var currNum2 = matrix[row][col + 1];
                var currNum3 = matrix[row + 1][col];
                var currNum4 = matrix[row + 1][col + 1];
                var currSum = currNum1 + currNum2 + currNum3 + currNum4;
                if (currSum > maxSum) {
                    maxSum = currSum;
                    rowOne = currNum1 + " " + currNum2;
                    rowTwo = currNum3 + " " + currNum4;
                }
            }
        }

        System.out.println(rowOne);
        System.out.println(rowTwo);
        System.out.println(maxSum);
    }
}
