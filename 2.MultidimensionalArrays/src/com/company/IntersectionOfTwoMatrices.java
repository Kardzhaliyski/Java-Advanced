package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class IntersectionOfTwoMatrices {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        int rows = Integer.parseInt(sc.nextLine());
        int cols = Integer.parseInt(sc.nextLine());
        var firstMatrix = new Character[rows][cols];
        populateMatrix(firstMatrix);
        var secoundMatrix = new Character[rows][cols];
        populateMatrix(secoundMatrix);
        printIntersections(firstMatrix,secoundMatrix);


    }

    private static void printIntersections(Character[][] firstMatrix, Character[][] secoundMatrix) {
        for (int rows = 0; rows < firstMatrix.length; rows++) {
            StringBuilder curRowString = new StringBuilder();
            for (int cols = 0; cols < firstMatrix[0].length; cols++) {
                if(firstMatrix[rows][cols].equals(secoundMatrix[rows][cols])){
                    curRowString.append(firstMatrix[rows][cols] + " ");
                } else {
                    curRowString.append("* ");
                }
            }

            System.out.println(curRowString);
        }
    }

    private static void populateMatrix(Character[][] matrix) {
        for (int rows = 0; rows < matrix.length; rows++) {
            String[] curRowStrings = sc.nextLine().split(" ",matrix[0].length);
            for (int cols = 0; cols < matrix[0].length; cols++) {
                matrix[rows][cols] = curRowStrings[cols].charAt(0);
            }
        }
    }


}
