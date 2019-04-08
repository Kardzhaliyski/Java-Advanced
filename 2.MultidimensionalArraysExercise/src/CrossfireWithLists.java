import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CrossfireWithLists {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        var sizesInput = sc.nextLine().split(" ");
        var rows = Integer.parseInt(sizesInput[0]);
        var cols = Integer.parseInt(sizesInput[1]);
        List<List<Integer>> matrix = new ArrayList<>();

        for (int row = 0; row < rows; row++) {
            matrix.add(new ArrayList<>());
            for (int col = 0; col < cols; col++) {
                matrix.get(row).add(row * cols + col + 1);
            }
        }

        while (true) {
            var stringInput = sc.nextLine();
            var cmnd = stringInput
                    .split(" ");
            if (stringInput.equals("Nuke it from orbit")) {
                break;
            }

            var fireRow = Integer.parseInt(cmnd[0]);
            var fireCol = Integer.parseInt(cmnd[1]);
            var fireRadius = Integer.parseInt(cmnd[2]);

            fire(matrix, fireRow, fireCol, fireRadius);
        }

        printMatrix(matrix);



    }

    private static void printMatrix(List<List<Integer>> matrix) {
        for (List<Integer> integers : matrix) {
            for (Integer integer : integers) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }

    private static void fire(List<List<Integer>> matrix, int fireRow, int fireCol, int fireRadius) {
        fireVertical(matrix, fireRow, fireCol, fireRadius);
        fireHorizontal(matrix, fireRow, fireCol, fireRadius);
        cleanEmptyRows(matrix);
    }

    private static void cleanEmptyRows(List<List<Integer>> matrix) {
        matrix.removeIf(a -> a.size() == 0);
    }

    private static void fireHorizontal(List<List<Integer>> matrix, int fireRow, int fireCol, int fireRadius) {
        if (fireRow < 0 || fireRow >= matrix.size()) {
            return;
        }

        var firstBurntIndex = fireCol - fireRadius;
        if (firstBurntIndex < 0) {
            firstBurntIndex = 0;
        } else if (firstBurntIndex >= matrix.get(fireRow).size()) {
            return;
        }

        var lastBurntIndex = fireCol + fireRadius + 1;
        if (lastBurntIndex < 0) {
            return;
        } else if (lastBurntIndex >= matrix.get(fireRow).size()) {
            lastBurntIndex = matrix.get(fireRow).size();
        }

        matrix.get(fireRow).subList(firstBurntIndex, lastBurntIndex).clear();
    }

    private static void fireVertical(List<List<Integer>> matrix, int fireRow, int fireCol, int fireRadius) {
        if (fireCol < 0) {
            return;
        }

        var firstBurntIndex = fireRow - fireRadius;
        if (firstBurntIndex < 0) {
            firstBurntIndex = 0;
        } else if (firstBurntIndex > matrix.size()) {
            return;
        }

        var lastBurntIndex = fireRow + fireRadius;
        if (lastBurntIndex < 0) {
            return;
        } else if (lastBurntIndex >= matrix.size()) {
            lastBurntIndex = matrix.size() - 1;
        }

        for (int row = firstBurntIndex; row <= lastBurntIndex; row++) {
            if (fireCol >= matrix.get(row).size() || row == fireRow) {
                continue;
            }

            matrix.get(row).remove(fireCol);
        }


    }
}
