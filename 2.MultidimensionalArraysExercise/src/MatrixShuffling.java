import java.util.Scanner;

public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        var sizeInput = sc
                .nextLine()
                .split("\\s+");
        var rows = Integer.parseInt(sizeInput[0]);
        var cols = Integer.parseInt(sizeInput[1]);
        var matrix = new String[rows][cols];

        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = sc
                    .nextLine()
                    .split("\\s+");
        }

        while (true) {
            var input = sc
                    .nextLine()
                    .split("\\s+");

            if (input[0].equals("END")) {
                break;
            }

            if (cmndIsValid(input, matrix)) {
                swapCells(matrix, input);
                printMatrix(matrix);
            } else {
                System.out.println("Invalid input!");
            }
        }


    }

    private static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                    System.out.print(matrix[row][col] + " ");
            }

            System.out.println();
        }
    }

    private static void swapCells(String[][] matrix, String[] input) {
        var row1 = Integer.parseInt(input[1]);
        var col1 = Integer.parseInt(input[2]);
        var row2 = Integer.parseInt(input[3]);
        var col2 = Integer.parseInt(input[4]);

        var tempString = matrix[row1][col1];
        matrix[row1][col1] = matrix[row2][col2];
        matrix[row2][col2] = tempString;
    }

    private static boolean cmndIsValid(String[] input, String[][] matrix) {
        if (!input[0].equals("swap")) {
            return false;
        }

        if (input.length != 5) {
            return false;
        }

        var row1 = Integer.parseInt(input[1]);
        var col1 = Integer.parseInt(input[2]);
        var row2 = Integer.parseInt(input[3]);
        var col2 = Integer.parseInt(input[4]);

        if(!isColValid(matrix, col1) || !isColValid(matrix, col2)){
            return false;
        }

        if(!isRowValid(matrix, row1) || !isRowValid(matrix, row2)){
            return false;
        }

        return true;

    }

    private static boolean isRowValid(String[][] matrix, int row) {
        return (row >= 0 && row < matrix.length);
    }

    private static boolean isColValid(String[][] matrix, int col) {
        return (col >= 0 && col < matrix[0].length);

    }
}
