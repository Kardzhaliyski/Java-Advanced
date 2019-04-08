import java.util.Scanner;

public class FillMatirx {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] sizeAndType = sc.nextLine().split(", ");
        int size = Integer.parseInt(sizeAndType[0]);
        String type = sizeAndType[1];
        int[][] matrix = new int[size][size];

        if (type.equals("A")) {
            fillMatrixTypeA(matrix);
        } else if (type.equals("B")) {
            fillMatrixTypeB(matrix);
        }

        printMatrix(matrix);
    }

    private static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                System.out.print(matrix[row][col] + " ");
            }

            System.out.println();
        }
    }

    private static void fillMatrixTypeB(int[][] matrix) {
        for (int col = 0; col < matrix.length; col++) {
            for (int row = 0; row < matrix.length; row++) {
                if (col % 2 == 0) {
                    matrix[row][col] = col * matrix.length + row + 1;
                } else if (col % 2 != 0){
                    matrix[row][col] = (col + 1) * matrix.length - row ;
                }
            }
        }

    }

    private static void fillMatrixTypeA(int[][] matrix) {
        for (int col = 0; col < matrix.length; col++) {
            for (int row = 0; row < matrix.length; row++) {
                matrix[row][col] = col * matrix.length + row + 1;
            }
        }
    }
}
