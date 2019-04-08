import java.util.Arrays;
import java.util.Scanner;

public class ReverseMatrixDiagonals {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        var sizesInput = sc.nextLine().split(" ");
        var rows = Integer.parseInt(sizesInput[0]);
        var matrix = new int[rows][];

        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = Arrays
                    .stream(sc.nextLine()
                            .split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        for (int index = 0; index < matrix[0].length; index++) {
            var row = matrix.length - 1;
            var col = matrix[0].length - index - 1;
            printDiagonal(matrix, row, col);
        }

        for (int index = 0; index < matrix.length - 1; index++) {
            var row = matrix.length - 2 - index;
            var col = 0;
            printDiagonal(matrix, row, col);
        }
    }

    public static void printDiagonal(int[][] matrix, int row, int col) {
        while (row >= 0 && col < matrix[0].length) {
            System.out.print(matrix[row][col] + " ");
            row--;
            col++;
        }

        System.out.println();
    }
}
