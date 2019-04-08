package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class WrongMeasurements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int matrixSize = Integer.parseInt(sc.nextLine());
        var matrix = new int[matrixSize][matrixSize];
        for (int i = 0; i < matrix.length; i++) {
            var input = Arrays
                    .stream(sc
                            .nextLine()
                            .split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix[i] = input;
        }

        var wrongNumberCordinates = sc.nextLine().split("\\s+");
        var wrongNumberRowIndex = Integer.parseInt(wrongNumberCordinates[0]);
        var wrongNumberColIndex = Integer.parseInt(wrongNumberCordinates[1]);
        var wrongNumber = matrix[wrongNumberRowIndex][wrongNumberColIndex];
        var correctMatrix = new int[matrixSize][];
        for (int row = 0; row < correctMatrix.length; row++) {
            correctMatrix[row] = matrix[row].clone();
        }
        findAndFix(matrix, correctMatrix, wrongNumber);

        printMatrix(correctMatrix);
    }

    private static void findAndFix(int[][] matrix, int[][] correctMatrix, int wrongNumber) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == wrongNumber) {
                    fixWrongNumber(matrix, correctMatrix, wrongNumber, row, col);
                }
            }
        }
    }

    private static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }

            System.out.println();
        }
    }

    private static void fixWrongNumber(int[][] matrix, int[][] correctMatrix, int wrongNumber, int row, int col) {

        int sum = 0;

        if (col > 0) {
            var currNum = matrix[row][col - 1];
            if (currNum != wrongNumber) {
                sum += currNum;
            }
        }

        if (row + 1 < matrix.length) {
            var currNum = matrix[row + 1][col];
            if (currNum != wrongNumber) {
                sum += currNum;
            }
        }

        if (col + 1 < matrix[row].length) {
            var currNum = matrix[row][col + 1];
            if (currNum != wrongNumber) {
                sum += currNum;
            }
        }

        if (row > 0) {
            var currNum = matrix[row - 1][col];
            if (currNum != wrongNumber) {
                sum += currNum;
            }
        }

        correctMatrix[row][col] = sum;
    }
}
