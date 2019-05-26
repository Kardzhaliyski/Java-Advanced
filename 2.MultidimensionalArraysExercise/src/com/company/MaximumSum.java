package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class MaximumSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        var sizesInput = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        var rows = sizesInput[0];
        var cols = sizesInput[1];
        var matrix = new int[rows][];
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = Arrays.stream(sc.nextLine().split("\\s+"))
                    .limit(cols)
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        var maxSum = 0L;
        var maxSumTopLeftCol = 0;
        var maxSumTopLeftRow = 0;

        for (int row = 0; row < matrix.length - 2; row++) {
            for (int col = 0; col < matrix[row].length - 2; col++) {
                var currSum = getSubMatrixSum(matrix, row, col);
                if(maxSum < currSum) {
                    maxSum = currSum;
                    maxSumTopLeftRow = row;
                    maxSumTopLeftCol = col;
                }
            }
        }

        System.out.println("Sum = " + maxSum);
        printSubMatrix(matrix, maxSumTopLeftRow, maxSumTopLeftCol);

    }

    private static void printSubMatrix(int[][] matrix, int maxSumTopLeftRow, int maxSumTopLeftCol) {
        for (int row = maxSumTopLeftRow; row < maxSumTopLeftRow + 3; row++) {
            for (int col = maxSumTopLeftCol; col < maxSumTopLeftCol + 3; col++) {
                System.out.print(matrix[row][col] + " ");
            }

            System.out.println();
        }
    }

    private static long getSubMatrixSum(int[][] matrix, int row, int col) {
        var sum = 0L;
        for (int currRow = row; currRow < row + 3; currRow++) {
            for (int currCol = col; currCol < col + 3; currCol++) {
                sum += matrix[currRow][currCol];
            }
        }

        return sum;
    }
}
