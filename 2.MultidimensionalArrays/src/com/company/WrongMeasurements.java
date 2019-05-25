package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class WrongMeasurements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        var matrixRows = Integer.parseInt(sc.nextLine());
        var matrix = new int[matrixRows][];
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = Arrays.stream(sc.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        var wrongNumberIndexes = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        var wrongNumber = matrix[wrongNumberIndexes[0]][wrongNumberIndexes[1]];

        fixWrongNumbers(matrix, wrongNumber);
    }

    private static void fixWrongNumbers(int[][] matrix, int wrongNumber) {
        var originalMatrix = new int[matrix.length][];
        for (int row = 0; row < matrix.length; row++) {
            originalMatrix[row] = matrix[row].clone();
        }

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] != wrongNumber) {
                    continue;
                }

                var sum = 0;
                if (row > 0 && originalMatrix[row - 1][col] != wrongNumber) {
                    sum += originalMatrix[row - 1][col];
                }

                if (row < matrix.length - 1 && originalMatrix[row + 1][col] != wrongNumber) {
                    sum += originalMatrix[row + 1][col];
                }

                if (col > 0 && originalMatrix[row][col - 1] != wrongNumber) {
                    sum += originalMatrix[row][col - 1];
                }

                if (col < matrix[0].length - 1 && originalMatrix[row][col + 1] != wrongNumber) {
                    sum += originalMatrix[row][col + 1];
                }

                matrix[row][col] = sum;
            }
        }

        for (int[] row : matrix) {
            for (int num : row) {
                System.out.print(num + " ");
            }

            System.out.println();
        }
    }
}
