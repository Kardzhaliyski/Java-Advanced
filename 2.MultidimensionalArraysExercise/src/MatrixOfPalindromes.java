import java.util.Scanner;

public class MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        var sizesInput = sc.nextLine().split("\\s+");
        var rows = Integer.parseInt(sizesInput[0]);
        var cols = Integer.parseInt(sizesInput[1]);
        var matrix = new String[rows][cols];

        matrixPalindromesFill(matrix);

    }

    private static void matrixPalindromesFill(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print("" + (char) ('a' + row)  + (char) ('a' + row + col) + (char) ('a' + row) + " ");
            }
            System.out.println();
        }
    }
}
