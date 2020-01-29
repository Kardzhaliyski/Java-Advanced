package speedracing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in))) {
            Map<String, Car> cars = new LinkedHashMap<>();
            var numberOfCars = Integer.parseInt(bfr.readLine());
            for (int i = 0; i < numberOfCars; i++) {
                var carInfo = bfr.readLine().split("\\s+");
                var carModel = carInfo[0];
                var carFuelAmount = carInfo[1];
                var carFuelCostPer1Km = carInfo[2];
                Car tempCar = new Car(carModel, carFuelAmount, carFuelCostPer1Km);
                cars.put(carModel, tempCar);
            }

            var tokens = bfr.readLine().split("\\s+");
            while (!tokens[0].equalsIgnoreCase("end")) {
                var model = tokens[1];
                var distance = Integer.parseInt(tokens[2]);
                cars.get(model).drive(distance);

                tokens = bfr.readLine().split("\\s+");
            }

            cars.forEach((k,v) -> System.out.println(v));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
