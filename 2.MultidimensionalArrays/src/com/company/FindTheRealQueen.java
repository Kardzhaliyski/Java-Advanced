package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class FindTheRealQueen {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        var chessBoard = new Character[8][8];
        var trueBoard = new boolean[8][8];
        for (boolean[] row : trueBoard) {
            Arrays.fill(row, true);
        }

        for (int row = 0; row < chessBoard.length; row++) {
            var input = sc.nextLine().split(" ");
            for (int charIndex = 0; charIndex < input.length; charIndex++) {
                chessBoard[row][charIndex] = input[charIndex].charAt(0);
            }
        }

        boolean queenFound = false;
        for (int row = 0; row < chessBoard.length; row++) {
            for (int col = 0; col < chessBoard.length; col++) {
                if(chessBoard[row][col] == 'q' && trueBoard[row][col]){
                    if(checkIfrealQueen(chessBoard,trueBoard, row, col)){
                        System.out.println(row + " " + col);
                        return;
                    }
                }
            }
        }
    }

    private static boolean checkIfrealQueen(Character[][] chessBoard,boolean[][] trueBoard, int row, int col) {
        int queensFound = 0;
        queensFound += checkSides(chessBoard, trueBoard, row, col);
        queensFound += checkDiagonals(chessBoard, trueBoard, row, col);


        if(queensFound > 0){
            trueBoard[row][col] = false;
            return false;
        }

        return true;
    }

    private static int checkSides(Character[][] chessBoard,boolean[][] trueBoard, int row, int col) {
        int queensFound = 0;
        for(int index = 0; index < chessBoard[row].length; index++){

            if(chessBoard[row][index] == 'q' && index != col){
                queensFound++;
                trueBoard[row][index] = false;
            }

            if(chessBoard[index][col] == 'q' && index != row){
                queensFound++;
                trueBoard[index][col] = false;
            }
        }

        return queensFound;
    }

    private  static int checkDiagonals(Character[][] chessBoard, boolean[][] trueBoard, int row, int col){
        int queensFound = 0;

        for (int index = 1; index <= chessBoard.length; index++) {
            int topRow = row - index;
            int leftCol = col - index;
            int botRow = row + index;
            int rightCol = col + index;
            if(topRow >= 0 && leftCol >= 0){
                if(chessBoard[topRow][leftCol] == 'q'){
                    queensFound++;
                    trueBoard[topRow][leftCol] = false;
                }
            }

            if(botRow < chessBoard.length && leftCol >= 0){
                if(chessBoard[botRow][leftCol] == 'q'){
                    queensFound++;
                    trueBoard[botRow][leftCol] = false;
                }
            }

            if(botRow < chessBoard.length && rightCol < chessBoard.length){
                if(chessBoard[botRow][rightCol] == 'q'){
                    queensFound++;
                    trueBoard[botRow][rightCol] = false;
                }
            }

            if(topRow >= 0 && rightCol < chessBoard.length){
                if(chessBoard[topRow][rightCol] == 'q'){
                    queensFound++;
                    trueBoard[topRow][rightCol] = false;
                }
            }

        }

        return queensFound;
    }




}
