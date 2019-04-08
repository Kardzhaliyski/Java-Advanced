import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class StringMatrixRotation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String cmnd = sc.nextLine().replaceAll("\\D+","");
        int rotationDegree = Integer.parseInt(cmnd);
        List<String> stringsList = new LinkedList<>();
        var longestString = 0;

        while (true) {
            var inptString = sc.nextLine();
            if(inptString.equals("END")){
                break;
            }

            if(inptString.length() > longestString){
                longestString = inptString.length();
            }

            stringsList.add(inptString);
        }

        char[][] matrix = new char[stringsList.size()][longestString];
        for (char[] row : matrix) {
            Arrays.fill(row, ' ');
        }

        fillListIntoMatrix(matrix, stringsList);
        matrix = rotateMatrix(matrix, rotationDegree);
        printMatrix(matrix);
    }

    private static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }

            System.out.println();
        }
    }

    private static char[][] rotateMatrix(char[][] matrix, int rotationDegree) {
        int rotationsAt90Degree = (rotationDegree / 90) % 4;
        for (int rotation = 0; rotation < rotationsAt90Degree; rotation++) {
            matrix = rotateMatrixAt90Degree(matrix);
        }

        return matrix;
    }

    private static char[][] rotateMatrixAt90Degree(char[][] matrix) {
        var tempMatrix = new char[matrix[0].length][matrix.length];
        for (int col = 0; col < matrix[0].length; col++) {
            for (int row = 0; row < matrix.length; row++) {
                tempMatrix[col][row] = matrix[matrix.length - row -1][col];
            }
        }

        return tempMatrix;
    }

    private static void fillListIntoMatrix(char[][] matrix, List<String> stringsList) {
        for (int row = 0; row < matrix.length; row++) {
            stringsList.get(row).getChars(0, stringsList.get(row).length(), matrix[row], 0);
        }
    }
}
