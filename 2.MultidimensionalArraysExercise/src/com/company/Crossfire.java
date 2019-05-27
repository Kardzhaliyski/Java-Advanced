package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Crossfire {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        var matrix = new ArrayList<ArrayList<Integer>>();
        var sizes = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        var rowsNum = sizes[0];
        var colsNum = sizes[1];
        for (int row = 0; row < sizes[0]; row++) {
            matrix.add(new ArrayList<>());
        }

        for (int row = 0; row < rowsNum; row++) {
            for (int col = 0; col < colsNum; col++) {
                matrix.get(row).add(1 + col + (colsNum * row));
            }
        }

        var input = "";
        while (!"Nuke it from orbit".equals(input = sc.nextLine())) {
            var tokens = input.split("\\s+");
            var targetRow = Integer.parseInt(tokens[0]);
            var targetCol = Integer.parseInt(tokens[1]);
            var firePower = Integer.parseInt(tokens[2]);

            destroyColCells(matrix, targetRow, targetCol, firePower);
            destroyRowCells(matrix, targetRow, targetCol, firePower);
            removeEmptyRows(matrix);

            System.out.println();
        }

        printMatrix(matrix);

    }

    private static void printMatrix(ArrayList<ArrayList<Integer>> matrix) {
        for (ArrayList<Integer> row : matrix) {
            for (Integer cell : row) {
                System.out.print(cell + " ");
            }

            System.out.println();
        }
    }

    private static void removeEmptyRows(ArrayList<ArrayList<Integer>> matrix) {
        for (int row = 0; row < matrix.size(); row++) {
            if (matrix.get(row).size() == 0) {
                matrix.remove(row);
                row = 0;
            }
        }
    }

    private static void destroyColCells(ArrayList<ArrayList<Integer>> matrix, int targetRow, int targetCol, int firePower) {
        var firstDestroyedRow = targetRow - firePower;
        var lastDestroyedRow = targetRow + firePower;

        if(targetCol < 0 ) {
            return;
        }

        if (firstDestroyedRow < 0) {
            firstDestroyedRow = 0;
        }

        if (lastDestroyedRow >= matrix.size()) {
            lastDestroyedRow = matrix.size() - 1;
        }

        if (firstDestroyedRow < matrix.size() && lastDestroyedRow > 0) {
            for (int row = firstDestroyedRow; row <= lastDestroyedRow; row++) {
                if (row == targetRow) {
                    continue;
                }

                if (matrix.get(row).size() > targetCol) {
                    matrix.get(row).remove(targetCol);
                }
            }
        }
    }

    private static void destroyRowCells(ArrayList<ArrayList<Integer>> matrix, int targetRow, int targetCol, int firePower) {
        var firstDestroyedCol = targetCol - firePower;
        var lastDestroyedCol = targetCol + firePower;

        if (targetRow < matrix.size() && targetRow >= 0) {

            if (firstDestroyedCol < 0) {
                firstDestroyedCol = 0;
            }

            if (lastDestroyedCol >= matrix.get(targetRow).size()) {
                lastDestroyedCol = matrix.get(targetRow).size() - 1;
            }

            if (firstDestroyedCol < matrix.get(targetRow).size() && lastDestroyedCol >= 0) {
                matrix.get(targetRow).subList(firstDestroyedCol, lastDestroyedCol + 1).clear();
            }

        }
    }
}
