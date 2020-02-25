package catlady;

import javafx.scene.paint.CycleMethod;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in))) {
            CatRepository catRepository = new CatRepository();

            var catData = bfr.readLine().split("\\s+");
            while (!catData[0].equals("End")) {
                var catBreed = catData[0];
                var catName = catData[1];
                var catSpecialParameter = Double.parseDouble(catData[2]);
                catRepository.addNewCatFromData(catBreed, catName, catSpecialParameter);

                catData = bfr.readLine().split("\\s+");
            }

            var catNameToPrint = bfr.readLine();
            catRepository.printCatData(catNameToPrint);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
