package rawdata;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in))) {
            var numberOfCars = Integer.parseInt(bfr.readLine());
            List<Car> cars = new ArrayList<>();
            for (int i = 0; i < numberOfCars; i++) {
                var rawDataInput = bfr.readLine().split("\\s+");
                Car tempCar = new Car(rawDataInput);
                cars.add(tempCar);
            }


            var command = bfr.readLine();
            if (command.equalsIgnoreCase("fragile")) {
                cars.stream().filter(c ->
                            c.cargo.type.equalsIgnoreCase("fragile") &&
                            c.getLowestTirePressure() < 1)
                        .forEach(c -> System.out.println(c.model));
            } else if(command.equalsIgnoreCase("flamable")) {
                cars.stream().filter(c ->
                            c.cargo.type.equalsIgnoreCase("flamable") &&
                            c.engine.power > 250)
                        .forEach(c -> System.out.println(c.model));
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
