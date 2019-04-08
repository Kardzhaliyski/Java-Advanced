import java.util.Scanner;

public class ParkingSystem2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        var sizeInput = sc.nextLine().split("\\s+");
        var parkingRows = Integer.parseInt(sizeInput[0]);
        var parkingCols = Integer.parseInt(sizeInput[1]);
        var takenSpots = new boolean[parkingRows][parkingCols];
        for (boolean[] row : takenSpots) {
            row[0] = true;
        }
        boolean[] fullRows = new boolean[parkingRows];

        String input = sc.nextLine();
        while (!input.equals("stop")) {
            String[] carData = input.split("\\s+");
            var carEnter = Integer.parseInt(carData[0]);
            var targetRow = Integer.parseInt(carData[1]);
            var targetCol = Integer.parseInt(carData[2]);

            if (!takenSpots[targetRow][targetCol]) {
                takenSpots[targetRow][targetCol] = true;
                printDistance(carEnter, targetRow, targetCol);
            } else if (fullRows[targetRow]) {
                System.out.printf("Row %d full%n", targetRow);
            } else {
                int maxDistance = Math.max(targetCol, (takenSpots[targetRow].length - targetCol) + 1);
                fullRows[targetRow] = true;
                for (int index = 1; index < maxDistance; index++) {

                    var frontCol = targetCol - index;
                    var endCol = targetCol + index;

                    if (frontCol > 0 &&
                            !takenSpots[targetRow][frontCol]) {
                        takenSpots[targetRow][frontCol] = true;
                        fullRows[targetRow] = false;
                        printDistance(carEnter, targetRow, frontCol);
                        break;
                    } else if (endCol < takenSpots[targetRow].length &&
                            !takenSpots[targetRow][endCol]) {
                        takenSpots[targetRow][endCol] = true;
                        fullRows[targetRow] = false;
                        printDistance(carEnter, targetRow, endCol);
                        break;
                    }
                }

                if (fullRows[targetRow]) {
                    System.out.printf("Row %d full%n", targetRow);
                }
            }


            input = sc.nextLine();
        }

    }

    private static void printDistance(int carEnter, int targetRow, int targetCol) {
        System.out.println(Math.abs(carEnter - targetRow) + targetCol + 1);
    }
}
