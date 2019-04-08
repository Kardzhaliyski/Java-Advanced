import java.util.Arrays;
import java.util.Scanner;

public class MaximumSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        var sizes = sc
                .nextLine()
                .split("\\s+");
        var rows = Integer.parseInt(sizes[0]);
        var cols = Integer.parseInt(sizes[1]);
        var matrix = new int[rows][cols];
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = Arrays
                    .stream(sc
                            .nextLine()
                            .split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        var maxSum = Integer.MIN_VALUE;
        var maxSumRowIndex = -1;
        var maxSumColIndex = -1;
        for (int row = 0; row < matrix.length - 2; row++) {
            for (int col = 0; col < matrix[row].length - 2; col++) {
                int currSum = getSubMatrixSum(matrix, row , col);
                if(currSum > maxSum){
                    maxSum = currSum;
                    maxSumRowIndex = row;
                    maxSumColIndex = col;
                }
            }
        }

        System.out.println("Sum = " + maxSum);
        printSubMatrix(matrix, maxSumRowIndex, maxSumColIndex);

    }

    private static void printSubMatrix(int[][] matrix, int row, int col) {
        for (int currRow = row; currRow < row + 3; currRow++) {
            for (int currCol = col; currCol < col + 3; currCol++) {
                System.out.print(matrix[currRow][currCol] + " ");
            }
            System.out.println();
        }
    }

    private static int getSubMatrixSum(int[][] matrix, int row, int col) {
        int sum = matrix[row][col] + matrix[row][col + 1] + matrix[row][col + 2];
         sum += matrix[row + 1][col] + matrix[row + 1][col + 1] + matrix[row + 1][col + 2];
         sum += matrix[row + 2][col] + matrix[row + 2][col + 1] + matrix[row + 2][col + 2];
        return sum;
    }
}
