package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class MaximumSumOf2x2Submatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        var dimensions = sc.nextLine().split(", ");
        var matrix = new int[Integer.parseInt(dimensions[0])][];
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = Arrays.stream(sc.nextLine().split(", "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        long maxSum = Long.MIN_VALUE;
        var maxSumRow = -1;
        var maxSumCol = -1;

        for (int row = 0; row < matrix.length - 1; row++) {
            for (int col = 0; col < matrix[row].length - 1; col++) {
                long currSum = findSubmatrixSum(matrix, row, col);
                if (maxSum < currSum) {
                    maxSum = currSum;
                    maxSumRow = row;
                    maxSumCol = col;
                }
            }
        }

        printSubMatrix(matrix, maxSumRow, maxSumCol, maxSum);

    }

    private static void printSubMatrix(int[][] matrix, int maxSumRow, int maxSumCol, long maxSum) {
        for (int row = maxSumRow; row < maxSumRow + 2; row++) {
            for (int col = maxSumCol; col < maxSumCol + 2; col++) {
                System.out.print(matrix[row][col] + " ");
            }

            System.out.println();
        }

        System.out.println(maxSum);
    }

    private static long findSubmatrixSum(int[][] matrix, int topLeftRow, int topLeftCol) {
        long sum = 0L;

        for (int row = topLeftRow; row < topLeftRow + 2; row++) {
            for (int col = topLeftCol; col < topLeftCol + 2; col++) {
                sum += matrix[row][col];
            }
        }

        return sum;
    }
}
