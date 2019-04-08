import java.util.Arrays;
import java.util.Scanner;

public class ParkingSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        var sizeInput = sc.nextLine().split("\\s+");
        var parkingRows = Integer.parseInt(sizeInput[0]);
        var parkingCols = Integer.parseInt(sizeInput[1]);
        boolean[][] parking = new boolean[parkingRows][parkingCols];
        for (boolean[] row : parking) {
            row[0] = true;
        }
        boolean[] fullRows = new boolean[parking.length];

        while (true) {
            String input = sc
                    .nextLine();
            if (input.equals("stop")) {
                break;
            }

            String[] carData = input.split("\\s+");
            int entryRow = Integer.parseInt(carData[0]);
            int targetRow = Integer.parseInt(carData[1]);
            int targetCol = Integer.parseInt(carData[2]);

            if (!parking[targetRow][targetCol]) {
                parking[targetRow][targetCol] = true;
                printTraveledDistance(entryRow, targetRow, targetCol);
                continue;
            }

            if (fullRows[targetRow]) {
                System.out.printf("Row %d full%n", targetRow);
                continue;
            }

            boolean rowFull = true;
            int maxDistance = Math.max(targetCol, (parking[targetRow].length - targetCol) + 1);
            for (int index = 1; index < maxDistance; index++) {
                int entrySideCol = targetCol - index;
                if (entrySideCol > 0 && parking[targetRow][entrySideCol] == false) {
                    parking[targetRow][entrySideCol] = true;
                    rowFull = false;
                    printTraveledDistance(entryRow, targetRow, entrySideCol);
                    break;
                }

                int rearSideCol = targetCol + index;
                if (rearSideCol < parking[targetRow].length && parking[targetRow][rearSideCol] == false) {
                    parking[targetRow][rearSideCol] = true;
                    rowFull = false;
                    printTraveledDistance(entryRow, targetRow, rearSideCol);
                    break;
                }
            }

            if (rowFull) {
                fullRows[targetRow] = true;
                System.out.printf("Row %d full%n", targetRow);
            }
        }
    }

    private static void printTraveledDistance(int entryRow, int parkRow, int parkCol) {
        System.out.println(Math.abs(entryRow - parkRow) + 1 + parkCol);
    }


}
