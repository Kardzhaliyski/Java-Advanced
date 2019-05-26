package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        var sizes = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        var matrix = new String[sizes[0]][];
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = sc.nextLine().split("\\s+");
        }

        var input = "";
        while (!"END".equals(input = sc.nextLine())) {
            var tokens = input.split("\\s+");
            if(!"swap".equals(tokens[0])) {
                System.out.println("Invalid input!");
                continue;
            }

            if(tokens.length != 5) {
                System.out.println("Invalid input!");
                continue;
            }

            var row1 = Integer.parseInt(tokens[1]);
            var col1 = Integer.parseInt(tokens[2]);
            var row2 = Integer.parseInt(tokens[3]);
            var col2 = Integer.parseInt(tokens[4]);
            if(0 > row1 || 0 > col1 || 0 > row2 || 0 > col2) {
                System.out.println("Invalid input!");
                continue;
            } else if(matrix.length <= row1 || matrix.length <= row2) {
                System.out.println("Invalid input!");
                continue;
            } else if(matrix[0].length <= col1 || matrix[0].length <= col2) {
                System.out.println("Invalid input!");
                continue;
            }

            var temp = matrix[row1][col1];
            matrix[row1][col1] = matrix[row2][col2];
            matrix[row2][col2] = temp;

            for (String[] row : matrix) {
                for (String str : row) {
                    System.out.print(str + " ");
                }

                System.out.println();
            }
        }
    }
}
