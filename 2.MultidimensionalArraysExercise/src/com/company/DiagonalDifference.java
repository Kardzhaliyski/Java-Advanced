package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        var size = Integer.parseInt(sc.nextLine());
        var matrix = new int[size][size];

        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = Arrays.stream(sc.nextLine().split("\\s+"))
                    .limit(size)
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        var firstDiagonalSum = 0;
        for (int index = 0; index < matrix.length; index++) {
            firstDiagonalSum += matrix[index][index];
        }

        var secoundDiagonalSum = 0;
        for (int index = 0; index < matrix.length; index++) {
            secoundDiagonalSum += matrix[matrix.length - index - 1][index];
        }

        System.out.println(Math.abs(firstDiagonalSum - secoundDiagonalSum));
    }
}
