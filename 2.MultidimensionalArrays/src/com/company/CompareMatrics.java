package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class CompareMatrics {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int[][] firstMatrix = createMatrix();
        populateMatrix(firstMatrix);
        int[][] secoundMatrix = createMatrix();
        populateMatrix(secoundMatrix);
        System.out.println(areEqual(firstMatrix, secoundMatrix) ? "equal" : "not equal");

    }

    private static int[][] createMatrix() {
        int[] dimentions = Arrays
                .stream(sc
                        .nextLine()
                        .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int rows = dimentions[0];
        int cols = dimentions[1];
        return new int[rows][cols];
    }

    private static boolean areEqual(int[][] firstMatrix, int[][] secoundMatrix) {
        if (firstMatrix.length != secoundMatrix.length || firstMatrix[0].length != secoundMatrix[0].length) {
            return false;
        }

        for (int row = 0; row < firstMatrix.length; row++) {
            for (int col = 0; col < firstMatrix[0].length; col++) {
                if (firstMatrix[row][col] != secoundMatrix[row][col]) {
                    return false;
                }
            }
        }

        return true;
    }

    private static void populateMatrix(int[][] firstMatrix) {
        for (int row = 0; row < firstMatrix.length; row++) {
            int[] curRowNumbers = Arrays
                    .stream(sc
                            .nextLine()
                            .split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            for (int col = 0; col < firstMatrix[0].length; col++) {
                firstMatrix[row][col] = curRowNumbers[col];
            }
        }
    }
}
