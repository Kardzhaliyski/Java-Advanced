package bookworm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in))) {
            String str = bfr.readLine();
            var fieldSize = Integer.parseInt(bfr.readLine());
            char[][] field = new char[fieldSize][];
            for (int i = 0; i < fieldSize; i++) {
                field[i] = bfr.readLine().toCharArray();
            }



            var playerRow = -1;
            var playerCol = -1;

            for (int row = 0; row < field.length; row++) {
                for (int col = 0; col < field[row].length; col++) {
                    if(field[row][col] == 'P') {
                        playerRow = row;
                        playerCol = col;
                        field[row][col] = '-';
                        break;
                    }
                }

                if(playerRow != -1) {
                    break;
                }
            }

            ArrayDeque<Character> charStack = new ArrayDeque<>();
            for (int index = 0 ; index < str.length(); index++) {
                charStack.push(str.charAt(index));
            }

            var command = bfr.readLine();
            while (!command.equalsIgnoreCase("end")) {
                var playerMoved = false;
                switch (command){
                    case "up": {
                        if(canGoUp(playerRow)) {
                            playerRow--;
                            playerMoved = true;
                        }
                        break;
                    }
                    case "right": {
                        if(canGoRight(playerCol, fieldSize)) {
                            playerCol++;
                            playerMoved = true;
                        }
                        break;
                    }
                    case "down": {
                        if(canGoDown(playerRow, fieldSize)) {
                            playerRow++;
                            playerMoved = true;
                        }
                        break;
                    }
                    case "left": {
                        if(canGoLeft(playerCol)) {
                            playerCol--;
                            playerMoved = true;
                        }
                        break;
                    }
                }

                if(playerMoved) {
                    if(field[playerRow][playerCol] != '-') {
                        charStack.push(field[playerRow][playerCol]);
                        field[playerRow][playerCol] = '-';
                    }
                } else {
                    if(!charStack.isEmpty()) {
                        charStack.pop();
                    }
                }

                command = bfr.readLine();
            }



            System.out.println(stringJoinStackInReverse(charStack));
            field[playerRow][playerCol] = 'P';
            printMatrix(field);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static StringBuilder stringJoinStackInReverse( ArrayDeque<Character> charStack) {
        StringBuilder sb = new StringBuilder();
        var stack = charStack.clone();
        while (!stack.isEmpty()) {
            sb.insert(0,stack.pop());
        }
        return sb;
    }

    private static void printMatrix(char[][] field) {
        for (char[] row : field) {
            for (char cell : row) {
                System.out.print(cell);
            }
            System.out.println();
        }
    }

    private static boolean canGoLeft(int playerCol) {
        return playerCol > 0;
    }

    private static boolean canGoDown(int playerRow, int fieldSize) {
        return playerRow < fieldSize - 1;
    }

    private static boolean canGoRight(int playerCol, int fieldSize) {
        return playerCol < fieldSize - 1;
    }

    private static boolean canGoUp(int playerRow) {
        return playerRow > 0;
    }
}
