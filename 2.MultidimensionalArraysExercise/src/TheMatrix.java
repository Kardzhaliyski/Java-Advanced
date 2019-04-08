import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class TheMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        var sizesInput = sc.nextLine().split("\\s+");
        var rows = Integer.parseInt(sizesInput[0]);
        var cols = Integer.parseInt(sizesInput[1]);
        var matrix = new char[rows][];
        var connected = new boolean[rows][cols];
        for (int row = 0; row < matrix.length; row++) {
            var inputString = sc.nextLine();
            inputString = inputString.replaceAll(" ", "");
            matrix[row] = inputString.toCharArray();
        }

        char fillSymbol = sc.nextLine().charAt(0);
        int[] firstCharPosition = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        char charToReplace = matrix[firstCharPosition[0]][firstCharPosition[1]];
        matrix[firstCharPosition[0]][firstCharPosition[1]] = fillSymbol;
        connected[firstCharPosition[0]][firstCharPosition[1]] = true;

        int cellsReplaced = 1;
        while (cellsReplaced > 0) {
            cellsReplaced = 0;

            for (int row = 0; row < matrix.length; row++) {
                for (int col = 0; col < matrix[row].length; col++) {
                    if (connected[row][col]) {
                        cellsReplaced += fillNearbyCells(matrix, connected, row, col, charToReplace, fillSymbol);
                    }
                }
            }
        }

        printMatrix(matrix);
    }

    private static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            System.out.println(new String(matrix[row]));
        }
    }

    private static int fillNearbyCells(char[][] matrix, boolean[][] connected, int row, int col, char charToReplace, char fillSymbol) {
        int replaceCount = 0;
        if (row > 0 &&
                !connected[row - 1][col] &&
                matrix[row - 1][col] == charToReplace) {

            matrix[row - 1][col] = fillSymbol;
            connected[row - 1][col] = true;
            replaceCount++;
        }

        if (row < matrix.length - 1 &&
                !connected[row + 1][col] &&
                matrix[row + 1][col] == charToReplace) {

            matrix[row + 1][col] = fillSymbol;
            connected[row + 1][col] = true;
            replaceCount++;
        }

        if (col > 0 &&
                !connected[row][col - 1] &&
                matrix[row][col - 1] == charToReplace) {

            matrix[row][col - 1] = fillSymbol;
            connected[row][col - 1] = true;
            replaceCount++;
        }

        if (col < matrix[row].length - 1 &&
                !connected[row][col + 1] &&
                matrix[row][col + 1] == charToReplace) {

            matrix[row][col + 1] = fillSymbol;
            connected[row][col + 1] = true;
            replaceCount++;
        }
        return replaceCount;
    }
}
