package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringMatrixRotation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> stringList = new ArrayList<>();
        var rotationDegrees = Integer.parseInt(sc
                .nextLine()
                .replaceAll("[^0-9?!.]",""));

        String input = "";
        while (!"END".equals(input = sc.nextLine())) {
            stringList.add(input);
        }

        var maxLength = getLongestStringLength(stringList);
        var matrix = new char[stringList.size()][maxLength];
        for (int row = 0; row < stringList.size(); row++) {
            char[] currCharArr = stringList.get(row).toCharArray();
            for (int col = 0; col < matrix[row].length; col++) {
                if(currCharArr.length > col) {
                    matrix[row][col] = currCharArr[col];
                } else {
                    matrix[row][col] = ' ';
                }
            }
        }

        switch (rotationDegrees % 360) {
            case 90: {
                matrix = rotate90Degree(matrix);
                break;
            }
            case 180: {
                matrix = rotate180Degree(matrix);
                break;
            }
            case 270: {
                matrix = rotate270Degree(matrix);
                break;
            }

            default:

        }

        for (char[] row : matrix) {
            for (char c : row) {
                System.out.print(c);
            }

            System.out.println();
        }

    }

    private static char[][] rotate270Degree(char[][] matrix) {
        var tempMatrix = new char[matrix[0].length][matrix.length];
        for (int col = 0; col < tempMatrix[0].length; col++) {
            for (int row = 0; row < tempMatrix.length; row++) {
                tempMatrix[tempMatrix.length - row - 1][col] = matrix[col][row];
            }
        }


        return tempMatrix;
    }

    private static char[][] rotate180Degree(char[][] matrix) {
        var tempMatrix = new char[matrix.length][matrix[0].length];
        for (int row = 0; row < tempMatrix.length; row++) {
            for (int col = 0; col < tempMatrix[row].length; col++) {
                tempMatrix[row][col] = matrix[matrix.length - 1 - row][matrix[row].length - 1 - col];
            }
        }

        return tempMatrix;
    }

    private static char[][] rotate90Degree(char[][] matrix) {
        var tempMatrix = new char[matrix[0].length][matrix.length];
        for (int row = 0; row < tempMatrix.length; row++) {
            for (int col = 0; col < tempMatrix[0].length; col++) {
                tempMatrix[row][col] = matrix[matrix.length - col - 1][row];
            }
        }

        return tempMatrix;
    }

    private static int getLongestStringLength(List<String> inputCharList) {
        var maxLength = -1;
        for (String s : inputCharList) {
            if(maxLength < s.length()) {
                maxLength = s.length();
            }
        }

        return maxLength;
    }
}
