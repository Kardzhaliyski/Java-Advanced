import java.util.ArrayDeque;
import java.util.Scanner;

public class Crossfire {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        var sizesInput = sc.nextLine().split("\\s+");
        var rows = Integer.parseInt(sizesInput[0]);
        var cols = Integer.parseInt(sizesInput[1]);
        var matrix = new String[rows][cols];
        fillMatrix(matrix);
        while (true) {
            String[] fireInfoString = sc.nextLine().split(" ");
            if (fireInfoString[0].equals("Nuke")) {
                break;
            }
            var fireRow = Integer.parseInt(fireInfoString[0]);
            var fireCol = Integer.parseInt(fireInfoString[1]);
            var fireRadius = Integer.parseInt(fireInfoString[2]);
            matrix = fire(matrix, fireRow, fireCol, fireRadius);
        }

        printMatrix(matrix);
    }

    private static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            StringBuilder rowString = new StringBuilder();
            for (int col = 0; col < matrix[row].length; col++) {
                rowString.append(matrix[row][col]).append(" ");
            }
            if(rowString.toString().trim().length() > 0)
            System.out.println(rowString.toString());
        }
    }

    private static String[][] fire(String[][] matrix, int fireRow, int fireCol, int fireRadius) {
        burnHorizontal(matrix, fireRow, fireCol, fireRadius);
        burnVertical(matrix, fireRow, fireCol, fireRadius);
        return cleanMatrix(matrix);
    }

    private static void burnVertical(String[][] matrix, int fireRow, int fireCol, int fireRadius) {
        if (fireRow >= matrix.length || fireRow < 0) {
            return;
        }

        long firstBurntIndex = (long) fireCol - fireRadius;
        if (firstBurntIndex < 0) {
            firstBurntIndex = 0;
        } else if (firstBurntIndex >= matrix[0].length) {
            return;
        }

        var lastBurntIndex = (long) fireCol + fireRadius;
        if (lastBurntIndex < 0) {
            return;
        } else if (lastBurntIndex >= matrix[0].length) {
            lastBurntIndex = matrix[0].length - 1;
        }

        for (int col = (int) firstBurntIndex; col <= lastBurntIndex; col++) {
            matrix[fireRow][col] = " ";
        }
    }

    private static String[][] cleanMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col].equals(" ")) {
                    for (int tempCol = col ; tempCol < matrix[row].length; tempCol++) {
                        if (!matrix[row][tempCol].equals(" ")) {
                            matrix[row][col] = matrix[row][tempCol];
                            matrix[row][tempCol] = " ";
                            break;
                        }
                    }
                }
            }
        }
        return  removeEmptyRows(matrix);
    }

    private static String[][] removeEmptyRows(String[][] matrix) {
        ArrayDeque<String[]> queue = new ArrayDeque<>();
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if(!matrix[row][col].equals(" ")){
                    queue.offer(matrix[row]);
                    break;
                }
            }


        }
        var tempMatrix = new String[queue.size()][];
        for (int i = 0; i < tempMatrix.length; i++) {
            tempMatrix[i] = queue.poll();
        }
        return tempMatrix;
    }

    private static void burnHorizontal(String[][] matrix, int fireRow, int fireCol, int fireRadius) {
        if (fireCol >= matrix[0].length || fireCol < 0) {
            return;
        }

        long firstBurntIndex = (long) fireRow - fireRadius;
        if (firstBurntIndex < 0) {
            firstBurntIndex = 0;
        } else if (firstBurntIndex >= matrix.length) {
            return;
        }

        var lastBurntIndex = (long) fireRow + fireRadius;
        if (lastBurntIndex < 0) {
            return;
        } else if (lastBurntIndex >= matrix.length) {
            lastBurntIndex = matrix.length - 1;
        }

        for (int row = (int) firstBurntIndex; row <= lastBurntIndex; row++) {
            matrix[row][fireCol] = " ";
        }
    }

    private static void fillMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = "" + (row * matrix[0].length + col + 1);
            }
        }
    }
}
