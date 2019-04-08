import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = Integer.parseInt(sc.nextLine());
        int[][] matrix = new int[size][size];
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = Arrays
                    .stream(sc
                            .nextLine()
                            .split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        var leftDiagonalSum = getLeftDiagonalSum(matrix);
        var rightDiagonalSum = getRightDiagonalSum(matrix);
        var difference = Math.abs(leftDiagonalSum - rightDiagonalSum);

        System.out.println(difference);
    }

    private static int getRightDiagonalSum(int[][] matrix) {
        var sum = 0;
        for (int index = 0; index < matrix.length; index++) {
            sum += matrix[index][matrix.length -1 - index];
        }
        return sum;
    }

    private static int getLeftDiagonalSum(int[][] matrix) {
        var sum = 0;
        for (int index = 0; index < matrix.length; index++) {
            sum += matrix[index][index];
        }

        return sum;
    }
}
