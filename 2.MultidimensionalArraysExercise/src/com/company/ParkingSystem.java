package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class ParkingSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        var parkingSize = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        var takenSpots = new boolean[parkingSize[0]][parkingSize[1]];
        for (int row = 0; row < takenSpots.length; row++) {
            takenSpots[row][0] = true;
        }

        var fullRows = new boolean[takenSpots.length];

        var carDataInput = "";
        while (!"stop".equalsIgnoreCase(carDataInput = sc.nextLine())) {
            var carData = carDataInput.split("\\s+");
            var enterFromRow = Integer.parseInt(carData[0]);
            var wantedRow = Integer.parseInt(carData[1]);
            if(!fullRows[wantedRow]) {
                var wantedCol = Integer.parseInt(carData[2]);
                var carParked = false;
                for (int i = 0; i < takenSpots[wantedRow].length ; i++) {
                    if(wantedCol - i > 0
                            && !takenSpots[wantedRow][wantedCol - i]) {
                        carParked = true;
                        takenSpots[wantedRow][wantedCol - i] = true;
                        var distanceTraveled = Math.abs(wantedRow - enterFromRow) + (wantedCol - i) + 1;
                        System.out.println(distanceTraveled);
                        break;
                    } else if (wantedCol + i < takenSpots[wantedRow].length
                            && !takenSpots[wantedRow][wantedCol + i]) {
                        takenSpots[wantedRow][wantedCol + i] = true;
                        carParked = true;
                        var distanceTraveled = Math.abs(wantedRow - enterFromRow) + (wantedCol + i) + 1;
                        System.out.println(distanceTraveled);
                        break;
                    }
                }

                if(!carParked) {
                    fullRows[wantedRow] = true;
                    System.out.printf("Row %s full", wantedRow);
                }
            } else {
                System.out.printf("Row %s full", wantedRow);
            }
        }

        System.out.println();


    }
}
