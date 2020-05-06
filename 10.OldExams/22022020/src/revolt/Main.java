package revolt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in))) {
            var matrixSize = Integer.parseInt(bfr.readLine());
            var turnCount = Integer.parseInt(bfr.readLine());

            var matrix = new char[matrixSize][];
            var playerRow = -1;
            for (int row = 0; row < matrix.length; row++) {
                var input = bfr.readLine();
                matrix[row] = input.toCharArray();
                if (input.contains("f")) {
                    playerRow = row;
                }
            }

            var playerCol = -1;
            for (int col = 0; col < matrix[playerRow].length; col++) {
                if (matrix[playerRow][col] == 'f') {
                    playerCol = col;
                    matrix[playerRow][playerCol] = '-';
                    break;
                }
            }

            while (turnCount-- > 0) {
                var command = bfr.readLine();
                switch (command) {
                    case "up": {
                        playerRow = moveUp(matrix, playerRow, playerCol);
                        break;
                    }
                    case "right": {
                        playerCol = moveRight(matrix, playerRow, playerCol);
                        break;
                    }
                    case "down": {
                        playerRow = moveDown(matrix, playerRow, playerCol);
                        break;
                    }
                    case "left": {
                        playerCol = moveLeft(matrix, playerRow, playerCol);
                        break;
                    }
                }

                if (matrix[playerRow][playerCol] == 'F') {
                    break;
                }
            }

            if (matrix[playerRow][playerCol] == 'F') {
                System.out.println("Player won!");
            } else {
                System.out.println("Player lost!");
            }

            matrix[playerRow][playerCol] = 'f';

            for (char[] row : matrix) {
                for (char cell : row) {
                    System.out.print(cell);
                }
                System.out.println();
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static int moveUp(char[][] matrix, int playerRow, int playerCol) {
        var nextRow = playerRow - 1;
        if (nextRow < 0) {
            nextRow = matrix.length - 1;
        }

        if (matrix[nextRow][playerCol] == 'T') {
            return playerRow;
        } else if (matrix[nextRow][playerCol] == 'B') {
//            nextRow--;
//            if (nextRow < 0) {
//                nextRow = matrix.length - 1;
//            }
            nextRow = moveUp(matrix, nextRow, playerCol);
        }

        return nextRow;
    }

    private static int moveDown(char[][] matrix, int playerRow, int playerCol) {
        var nextRow = playerRow + 1;
        if (nextRow >= matrix.length) {
            nextRow = 0;
        }

        if (matrix[nextRow][playerCol] == 'T') {
            return playerRow;
        } else if (matrix[nextRow][playerCol] == 'B') {
//            nextRow++;
//            if (nextRow >= matrix.length) {
//                nextRow = 0;
//            }
            nextRow = moveDown(matrix, nextRow, playerCol);
        }

        return nextRow;
    }

    private static int moveRight(char[][] matrix, int playerRow, int playerCol) {
        var nextCol = playerCol + 1;
        if (nextCol >= matrix[playerRow].length) {
            nextCol = 0;
        }

        if (matrix[playerRow][nextCol] == 'T') {
            return playerCol;
        } else if (matrix[playerRow][nextCol] == 'B') {
//            nextCol++;
//            if (nextCol >= matrix[playerRow].length) {
//                nextCol = 0;
//            }
            nextCol = moveRight(matrix, playerRow, nextCol);

        }

        return nextCol;
    }

    private static int moveLeft(char[][] matrix, int playerRow, int playerCol) {
        var nextCol = playerCol - 1;
        if (nextCol < 0) {
            nextCol = matrix[playerRow].length - 1;
        }

        if (matrix[playerRow][nextCol] == 'T') {
            return playerCol;
        } else if (matrix[playerRow][nextCol] == 'B') {
//            nextCol--;
//            if (nextCol < 0) {
//                nextCol = matrix[playerRow].length - 1;
//            }
            nextCol = moveLeft(matrix, playerRow, nextCol);
        }

        return nextCol;
    }
}
