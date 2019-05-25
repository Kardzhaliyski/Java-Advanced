package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class FindTheRealQueen {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        var chessBoard = new char[8][8];
        for (int row = 0; row < chessBoard.length; row++) {

            var input = sc.nextLine().split(" ");

            for (int col = 0; col < chessBoard[row].length; col++) {
                chessBoard[row][col] = input[col].charAt(0);
            }
        }

        var trueQueenCheckMatrix = new boolean[8][8];
        for (int row = 0; row < trueQueenCheckMatrix.length; row++) {
            Arrays.fill(trueQueenCheckMatrix[row], true);
        }

        for (int row = 0; row < chessBoard.length; row++) {
            for (int col = 0; col < chessBoard[row].length; col++) {
                if (chessBoard[row][col] == 'q' && trueQueenCheckMatrix[row][col]) {
                    if (checkIfTrueQueen(chessBoard, trueQueenCheckMatrix, row, col)) {
                        System.out.println(row + " " + col);
                    }
                }
            }
        }

    }

    private static boolean checkIfTrueQueen(char[][] chessBoard, boolean[][] trueQueenCheckMatrix, int row, int col) {
        otherQueensOnRow(chessBoard, trueQueenCheckMatrix, row, col);
        otherQueensOnCol(chessBoard, trueQueenCheckMatrix, row, col);
        otherQueensOnDiagonals(chessBoard, trueQueenCheckMatrix, row, col);

        return trueQueenCheckMatrix[row][col];
    }

    private static void otherQueensOnDiagonals(char[][] chessBoard, boolean[][] trueQueenCheckMatrix, int row, int col) {
        otherQueensOnTopLeftDiagonal(chessBoard, trueQueenCheckMatrix, row, col);
        otherQueensOnTopRightDiagonal(chessBoard, trueQueenCheckMatrix, row, col);
        otherQueensOnBottomRightDiagonal(chessBoard, trueQueenCheckMatrix, row, col);
        otherQueensOnBottomLeftDiagonal(chessBoard, trueQueenCheckMatrix, row, col);
    }


    private static void otherQueensOnBottomLeftDiagonal(char[][] chessBoard, boolean[][] trueQueenCheckMatrix, int row, int col) {
        boolean otherQueenFound = false;
        for (int i = 1; i < chessBoard.length; i++) {
            var currRow = row + i;
            var currCol = col - i;
            if (currRow >= chessBoard.length || currCol < 0) {
                break;
            }

            if (chessBoard[currRow][currCol] == 'q') {
                otherQueenFound = true;
                trueQueenCheckMatrix[currRow][currCol] = false;
            }
        }

        if (otherQueenFound) {
            trueQueenCheckMatrix[row][col] = false;
        }

    }

    private static void otherQueensOnTopRightDiagonal(char[][] chessBoard, boolean[][] trueQueenCheckMatrix, int row, int col) {
        boolean otherQueenFound = false;
        for (int i = 1; i < chessBoard.length; i++) {
            var currRow = row - i;
            var currCol = col + i;
            if (currRow < 0 || currCol >= chessBoard.length) {
                break;
            }

            if (chessBoard[currRow][currCol] == 'q') {
                otherQueenFound = true;
                trueQueenCheckMatrix[currRow][currCol] = false;
            }
        }

        if (otherQueenFound) {
            trueQueenCheckMatrix[row][col] = false;
        }
    }

    private static void otherQueensOnBottomRightDiagonal(char[][] chessBoard, boolean[][] trueQueenCheckMatrix, int row, int col) {
        boolean otherQueenFound = false;
        for (int i = 1; i < chessBoard.length; i++) {
            var currRow = row + i;
            var currCol = col + i;
            if (currRow >= chessBoard.length || currCol >= chessBoard.length) {
                break;
            }

            if (chessBoard[currRow][currCol] == 'q') {
                otherQueenFound = true;
                trueQueenCheckMatrix[currRow][currCol] = false;
            }
        }

        if (otherQueenFound) {
            trueQueenCheckMatrix[row][col] = false;
        }
    }

    private static void otherQueensOnTopLeftDiagonal(char[][] chessBoard, boolean[][] trueQueenCheckMatrix, int row, int col) {
        boolean otherQueenFound = false;
        for (int i = 1; i < chessBoard.length; i++) {
            var currRow = row - i;
            var currCol = col - i;
            if (currRow < 0 || currCol < 0) {
                break;
            }

            if (chessBoard[currRow][currCol] == 'q') {
                otherQueenFound = true;
                trueQueenCheckMatrix[currRow][currCol] = false;
            }
        }

        if (otherQueenFound) {
            trueQueenCheckMatrix[row][col] = false;
        }
    }

    private static void otherQueensOnCol(char[][] chessBoard, boolean[][] trueQueenCheckMatrix, int row, int col) {
        boolean otherQueenFound = false;
        for (int currRow = 0; currRow < chessBoard.length; currRow++) {
            if (currRow == row) {
                continue;
            }

            if (chessBoard[currRow][col] == 'q') {
                otherQueenFound = true;
                trueQueenCheckMatrix[currRow][col] = false;
            }
        }

        if (otherQueenFound) {
            trueQueenCheckMatrix[row][col] = false;
        }
    }


    private static void otherQueensOnRow(char[][] chessBoard, boolean[][] trueQueenCheckMatrix, int row, int col) {
        boolean otherQueenFound = false;
        for (int currCol = 0; currCol < chessBoard[row].length; currCol++) {
            if (currCol == col) {
                continue;
            }

            if (chessBoard[row][currCol] == 'q') {
                otherQueenFound = true;
                trueQueenCheckMatrix[row][currCol] = false;
            }
        }

        if (otherQueenFound) {
            trueQueenCheckMatrix[row][col] = false;
        }
    }
}
