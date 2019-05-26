package com.company;

import java.util.Scanner;

public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        var input = sc.nextLine().split(", ");
        var size = Integer.parseInt(input[0]);
        var matrix = new int[size][size];
        var fillMethod = input[1];

        if ("A".equalsIgnoreCase(fillMethod)) {
            fillMatrixMethodA(matrix);
        } else if ("B".equalsIgnoreCase(fillMethod)) {
            fillMatrixMethodB(matrix);
        }

        for (int[] row : matrix) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }

            System.out.println();
        }
    }

    private static void fillMatrixMethodB(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if(col % 2 == 0){
                    matrix[row][col] = col * matrix.length + row + 1;
                } else {
                    matrix[row][col] = ((col + 1) * matrix.length) - row;
                }
            }
        }
    }

    private static void fillMatrixMethodA(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = col * matrix.length + row + 1;
            }
        }
    }
}
