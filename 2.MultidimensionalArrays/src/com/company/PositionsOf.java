package com.company;

import java.util.Arrays;
import java.util.Scanner;


public class PositionsOf {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int[][] matrix = createMatrix();
        populateMatrix(matrix);
        int numberToFind = Integer.parseInt(sc.nextLine());
        printNumberPositions(matrix, numberToFind);


    }

    private static void printNumberPositions(int[][] matrix, int numberToFind) {
        boolean foundNum = false;
        for (int rows = 0; rows < matrix.length; rows++) {
            for (int cols = 0; cols < matrix[0].length; cols++) {
                if(matrix[rows][cols] == numberToFind){
                    foundNum = true;
                    System.out.println(rows + " " + cols);
                }
            }
        }

        if(!foundNum){
            System.out.println("not found");
        }
    }

    private static void populateMatrix(int[][] matrix) {
        for (int rows = 0; rows < matrix.length; rows++) {
            int[] curRowNums = Arrays
                    .stream(sc.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            for (int cols = 0; cols < matrix[0].length; cols++) {
                matrix[rows][cols] = curRowNums[cols];
            }
        }
    }

    private static int[][] createMatrix() {

        String dimensions = sc.nextLine();
        int[] matrixDimensions = Arrays
                .stream(dimensions.split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int rows = matrixDimensions[0];
        int cols = matrixDimensions[1];
        return new int[rows][cols];
    }
}
