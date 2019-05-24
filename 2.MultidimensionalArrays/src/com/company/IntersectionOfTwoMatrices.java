package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        var rows = Integer.parseInt(sc.nextLine());
        var firstMatrix = new Character[rows][];
        for (int row = 0; row < firstMatrix.length; row++) {
            firstMatrix[row] = Arrays.stream(sc.nextLine().split(" ")).map(s -> s.charAt(0)).toArray(Character[]::new);
        }

        var secoundMatrix = new Character[rows][];
        for (int row = 0; row < secoundMatrix.length; row++) {
            secoundMatrix[row] = Arrays.stream(sc.nextLine().split(" ")).map(s -> s.charAt(0)).toArray(Character[]::new);
        }

        var cols = Integer.parseInt(sc.nextLine());
        var newMatrix = new char[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if(firstMatrix[row][col] == secoundMatrix[row][col]) {
                    newMatrix[row][col] = firstMatrix[row][col];
                } else {
                    newMatrix[row][col] = '*';
                }
            }
        }

        for (char[] row : newMatrix) {
            for (char col : row) {
                System.out.print(col + " ");
            }

            System.out.println();
        }

    }
}
